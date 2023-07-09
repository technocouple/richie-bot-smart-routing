package com.technocouple.richiebot.smartrouting.utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.technocouple.richiebot.smartrouting.chat.bison.model.ChatBIsonRequest;
import com.technocouple.richiebot.smartrouting.chat.bison.model.ChatBisonResponse;
import com.technocouple.richiebot.smartrouting.chat.bison.model.Examples;
import com.technocouple.richiebot.smartrouting.chat.bison.model.Input;
import com.technocouple.richiebot.smartrouting.chat.bison.model.InstancesChat;
import com.technocouple.richiebot.smartrouting.chat.bison.model.Messages;
import com.technocouple.richiebot.smartrouting.chat.bison.model.Output;
import com.technocouple.richiebot.smartrouting.text.bison.model.Instances;
import com.technocouple.richiebot.smartrouting.text.bison.model.Parameters;
import com.technocouple.richiebot.smartrouting.text.bison.model.TextBisonPredictRequest;
import com.technocouple.richiebot.smartrouting.text.bison.model.TextBisonPredictResponse;


public class GoogleGenerativeAIUtility {
	
	private static Logger logger = LoggerFactory.getLogger(GoogleGenerativeAIUtility.class);
	private static int counter = 0;
	private static String userTxt = "";
	private static String botTxt = "";
	private static Messages messages  = new Messages();
	private static List<Messages> message = new LinkedList<>();
	private static List<Messages> messageBkup = new LinkedList<>();
	private static List<String> words = new ArrayList<>();
	private static String prompt = "";
	
	static {
		words.add("ALL_INFO_COLLECTED");
		words.add("UNRELATED");
		words.add("INCOMPLETE_INFO");
	}
	
	public static String identifyIntent(String userUtterance) {
		
		String formattedPrompt = String.format(Constants.INTENT_PROMPT, userUtterance);
		ResponseEntity<TextBisonPredictResponse> response =  null;
		String textBisonAIResponse = "";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.ALL);
		headers.setAccept(list);
		headers.setBearerAuth(Constants.GCP_TOKEN);

		TextBisonPredictRequest mRequest = new TextBisonPredictRequest();
		Instances instances = new Instances();
		instances.setContent(formattedPrompt);
		
		Parameters parameters = new Parameters();
		parameters.setTemperature(0);
		parameters.setMaxOutputTokens(500);
		parameters.setTopK(40);
		parameters.setTopP(0.8);
		
		List<Instances> instList = new ArrayList<>();
		instList.add(instances);
		mRequest.setInstances(instList);
		mRequest.setParameters(parameters);
		
		
		try {
			HttpEntity<TextBisonPredictRequest> waRequest = new HttpEntity<TextBisonPredictRequest>(mRequest, headers);
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(Constants.TEXT_BISON_URL, HttpMethod.POST, waRequest, TextBisonPredictResponse.class);
			textBisonAIResponse = response.getBody().getPredictions().get(0).getContent();
			logger.info("TEXT-BISON AI RESPONSE :: " + textBisonAIResponse);
			
		}
		catch(Exception e) {
			logger.info("Exception in Intent Identification :: " + e.getMessage());
		}
		return textBisonAIResponse;
	}
	
	public static String chatSummarization() {
		String summary = "";
		//logger.info("MessageBkUp " + messageBkup);
		for(Messages ele : messageBkup) {
			if((ele.getAuthor().equalsIgnoreCase("user") && ele.getContent().contains("name")) ||
					(ele.getAuthor().equalsIgnoreCase("bot") && ele.getContent().contains("Richie"))) {
				//do nothing
			}
			else {
				summary = summary + " " + ele.getAuthor() + " , " + ele.getContent() + " ";
			}
		}
		logger.info("CHAT SUMMARIZATION :: " + summary);
		
		
		return summary;
	}
	
	public static String callBot(String userTxtFrmController, String botTxtFrmController, String intent) {
		
		logger.info("CHAT-BISON REQUEST FOR NEXT BEST ACTION WITH INPUT'S: USER-TEXT :: " + userTxtFrmController);
		GoogleGenerativeAIUtility.userTxt = userTxtFrmController;
		GoogleGenerativeAIUtility.botTxt = botTxtFrmController;
		
		if(counter == 0) {
			messages.setAuthor("user");
			messages.setContent(userTxt);
			message.add(messages);
			botTxt = chatWithBot(message, intent);
			counter++;
		}else {
			//System.out.println("Before Messages " + messages);
			messages  = new Messages();
			messages.setAuthor("bot");
			messages.setContent(botTxt);
			
			message.add(messages);
			messages  = new Messages();
			messages.setAuthor("user");
			messages.setContent(userTxt);
			
			message.add(messages);
			//System.out.println("after Messages " + messages);
			//System.out.println("Linkedlist " + message.size());
			botTxt = chatWithBot(message, intent);
			
			if(words.contains(botTxt)) {
			  counter = 0;
			  messageBkup.addAll(message);
			  message.clear();
			}
			else{
			 counter++;
			 }
		}
		logger.info("CHAT-BISON RESPONSE THE NEXT BEST ACTION (BOT TEXT) :: " + botTxt);
		return botTxt;
	}
	
	public static String chatWithBot(List<Messages> message, String intent) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> list = new ArrayList<MediaType>();

		list.add(MediaType.ALL);
		headers.setAccept(list);
		headers.setBearerAuth(Constants.GCP_TOKEN);

		ChatBIsonRequest cRequest = new ChatBIsonRequest();
		InstancesChat instances = new InstancesChat();
		
		Examples examples = new Examples();
		Input input = new Input();
		input.setAuthor("user");
		input.setContent("what is your name?");
		Output output = new Output();
		output.setAuthor("bot");
		output.setContent("my name is Richie, RICHIE BOT.");
		examples.setInput(input);
		examples.setOutput(output);
		
		List<Examples> ex = new ArrayList<>();
		ex.add(examples);
		
		
		if(intent.equalsIgnoreCase("credit_card")){
			prompt = Constants.CHAT_CONTEXT_PROMPT_CC;
		}else if(intent.equalsIgnoreCase("debit_card")) {
			prompt = Constants.CHAT_CONTEXT_PROMPT_DC;
		}else if(intent.equalsIgnoreCase("auto_loan")) {
			prompt = Constants.CHAT_CONTEXT_PROMPT_AL;
		}else {
			prompt = Constants.CHAT_CONTEXT_PROMPT_HL;
		}
		
		instances.setContext(prompt);
		instances.setExamples(ex);
		instances.setMessages(message);
		
		
		Parameters parameters = new Parameters();
		parameters.setTemperature(0);
		parameters.setMaxOutputTokens(500);
		parameters.setTopK(40);
		parameters.setTopP(0.8);
		
		List<InstancesChat> instList = new ArrayList<>();
		instList.add(instances);
		cRequest.setInstances(instList);
		cRequest.setParameters(parameters);
		
		//logger.info("Full Request " + cRequest);
		
		ResponseEntity<ChatBisonResponse> response =  null;
		String chatBisonAIResponse = "";
		try {
			HttpEntity<ChatBIsonRequest> waRequest = new HttpEntity<ChatBIsonRequest>(cRequest, headers);
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(Constants.CHAT_BISON_URL, HttpMethod.POST, waRequest, ChatBisonResponse.class);
			chatBisonAIResponse  = response.getBody().getPredictions().get(0).getCandidates().get(0).getContent();
			logger.info("CHAT BISON AI RESPONSE :: " + chatBisonAIResponse);
			
		}
		catch(Exception e) {
			logger.info("Exception in ChatBot Processing :: " + e.getMessage());
		}
	
		return chatBisonAIResponse;
	}
	
	public static String queueIdentification(String summary) {

		String formattedPrompt = String.format(Constants.QUEUE_IDENTIFIER_PROMPT, summary);
		ResponseEntity<TextBisonPredictResponse> response =  null;
		String queueIdentifierAIResponse = "";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> list = new ArrayList<MediaType>();

		list.add(MediaType.ALL);
		headers.setAccept(list);
		headers.setBearerAuth(Constants.GCP_TOKEN);

		TextBisonPredictRequest mRequest = new TextBisonPredictRequest();
		Instances instances = new Instances();
		instances.setContent(formattedPrompt);
		
		Parameters parameters = new Parameters();
		parameters.setTemperature(0);
		parameters.setMaxOutputTokens(500);
		parameters.setTopK(40);
		parameters.setTopP(0.8);
		
		List<Instances> instList = new ArrayList<>();
		instList.add(instances);
		mRequest.setInstances(instList);
		mRequest.setParameters(parameters);
		
		
		try {
			HttpEntity<TextBisonPredictRequest> waRequest = new HttpEntity<TextBisonPredictRequest>(mRequest, headers);
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(Constants.TEXT_BISON_URL, HttpMethod.POST, waRequest, TextBisonPredictResponse.class);
			queueIdentifierAIResponse = response.getBody().getPredictions().get(0).getContent();
			logger.info("QUEUE IDENTIFIED FROM AI AS :: " + queueIdentifierAIResponse);
			
		}
		catch(Exception e) {
			logger.info("Exception in Queue Identification :: " + e.getMessage());
		}
		return queueIdentifierAIResponse;
		
	
	}

}

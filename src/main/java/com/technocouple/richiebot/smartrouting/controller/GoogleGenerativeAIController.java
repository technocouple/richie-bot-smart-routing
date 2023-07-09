package com.technocouple.richiebot.smartrouting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technocouple.richiebot.smartrouting.text.bison.model.VoiceflowRes;
import com.technocouple.richiebot.smartrouting.utility.GoogleGenerativeAIUtility;
/**
 * 
 * @author TechnoCouple
 *
 */
@RestController
public class GoogleGenerativeAIController {
	
	private static Logger logger = LoggerFactory.getLogger(GoogleGenerativeAIController.class);
	private static String intent_id = ""; 
	//credit_card, debit_card, home_loan, auto_loan
	
	
	@GetMapping(path="/getIntent")
	public VoiceflowRes getIntent(@RequestParam String userUtterance) {
		logger.info("Request Received for Identifying Intent With User Utterance :: " + userUtterance + ". \n");
		VoiceflowRes voiceflowRes = new VoiceflowRes();
		intent_id = GoogleGenerativeAIUtility.identifyIntent(userUtterance);
		voiceflowRes.setText(intent_id);
		return voiceflowRes;
		
	}
	
	@GetMapping(path="/chat")
	public VoiceflowRes chatWithBison(@RequestParam String userTxt, @RequestParam String botTxt) {
		logger.info("Chat Request : USER TEXT :: " + userTxt + ", BOT TEXT :: " + botTxt + ". \n");
		VoiceflowRes voiceflowRes = new VoiceflowRes();
		voiceflowRes.setText(GoogleGenerativeAIUtility.callBot(userTxt,botTxt,intent_id));
		return voiceflowRes;
	}
	
	@GetMapping(path="/getQueueName")
	public VoiceflowRes chatSummary() {
		logger.info("Request Received to Identify RIGHT QUEUE for the given Interaction Summary and User Needs. \n");
		VoiceflowRes voiceflowRes = new VoiceflowRes();
		voiceflowRes.setText(GoogleGenerativeAIUtility.queueIdentification(GoogleGenerativeAIUtility.chatSummarization()));
		return voiceflowRes;
	}
	

}

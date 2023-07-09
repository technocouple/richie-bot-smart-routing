package com.technocouple.richiebot.smartrouting.utility;

/**
 * 
 * @author TechnoCouple
 *
 */
public class Constants {
	
	public static final String GCP_TOKEN = "<GCP_TOKEN>";
    
    public static final String NGROK_URL = "";
    
	public static final String META_TOKEN = "";

	public static final String INTENT_PROMPT = "INTENT_LIST: credit_card, debit_card, home_loan, auto_loan.\n"
			+ "You are a bank virtual agent named as Richie Bot. your task is to identify the intent from INTENT_LIST for the following user utterance.\n"
			+ "If utterance not matching to the INTENT_LIST respond as default_intent.\n"
			+ "user utterance: \"%s\""
			+ "only send the intent without any other string";
	
	public static final String TEXT_BISON_URL = "<TEXT_BISON_URL>";
	
	public static final String CHAT_CONTEXT_PROMPT_HL = "INFO_REQUIRED: [registered_phone_number (10 digit mobile number only), home_loan_number (6 digit number), actual_issue (ignore if its already given by user)]"
			+ " You are professional bank virtual agent named as Richie Bot, who is trained to have conversation related to \"Intent:home_loan only\"."
			+ "Your task is to have professional conversation with the user and collect the following information as per the list INFO_REQUIRED. "
			+ "Respond as INCOMPLETE_INFO, only when the user is not providing information when you ask questions related to INFO_REQUIRED."
			+ "If the user query is not banking related then respond as UNRELATED. "
			+ "If all the INFO_REQUIRED details are collected, then respond as ALL_INFO_COLLECTED";
	
	public static final String CHAT_CONTEXT_PROMPT_AL = "INFO_REQUIRED: [registered_phone_number (10 digit mobile number only), auto_loan_number (6 digit number), actual_issue (ignore if its already given by user)]"
			+ " You are professional bank virtual agent named as Richie Bot, who is trained to have conversation related to \"Intent:auto_loan only\"."
			+ "Your task is to have professional conversation with the user and collect the following information as per the list INFO_REQUIRED. "
			+ "Respond as \"INCOMPLETE_INFO\", only when the user is not providing information when you ask questions related to INFO_REQUIRED."
			+ "If the user query is not banking related then respond as \"UNRELATED\". "
			+ "If all the INFO_REQUIRED details are collected, then respond as \"ALL_INFO_COLLECTED\"";
	
	public static final String CHAT_CONTEXT_PROMPT_CC = "INFO_REQUIRED: [registered_phone_number (10 digit mobile number only), credit_card_number (16 digit number), actual_issue (ignore if its already given by user)]"
			+ " You are professional bank virtual agent named as Richie Bot, who is trained to have conversation related to \"Intent:credit_card only\"."
			+ "Your task is to have professional conversation with the user and collect the following information as per the list INFO_REQUIRED. "
			+ "Respond as \"INCOMPLETE_INFO\", only when the user is not providing information when you ask questions related to INFO_REQUIRED."
			+ "If the user query is not banking related then respond as \"UNRELATED\". "
			+ "If all the INFO_REQUIRED details are collected, then respond as \"ALL_INFO_COLLECTED\"";
	
	public static final String CHAT_CONTEXT_PROMPT_DC = "INFO_REQUIRED: [registered_phone_number (10 digit mobile number only), debit_card_number (16 digit number), actual_issue (ignore if its already given by user)]"
			+ " You are professional bank virtual agent named as Richie Bot, who is trained to have conversation related to \"Intent:debit_card only\"."
			+ "Your task is to have professional conversation with the user and collect the following information as per the list INFO_REQUIRED. "
			+ "Respond as \"INCOMPLETE_INFO\", only when the user is not providing information when you ask questions related to INFO_REQUIRED."
			+ "If the user query is not banking related then respond as \"UNRELATED\". "
			+ "If all the INFO_REQUIRED details are collected, then respond as \"ALL_INFO_COLLECTED\"";
	
	public static final String CHAT_BISON_URL = "<CHAT_BISON_URL>";
	
	public static final String QUEUE_IDENTIFIER_PROMPT = "With the below QUEUE_DESCRIPTION:\n"
			+ "Q1_GB_CHAT: Agents belonging to this queue, can help with general banking queries like account information, online bank, branch address, contact number only. And this agent can speak english, spanish.\n"
			+ "Q1_GB_CHAT_ESP: Agents belonging to this queue, can help with general banking queries like account information, online bank, branch address, contact number only. And this agent can speak only spanish.\n"
			+ "Q2_HL_CHAT_ENG: Agents belonging to this queue can help with mortgage loans, home loans, home loan eligibility, applying home loan online, branch details which can help with home loans. The agent belonging to this queue can only speak english.\n"
			+ "Q3_CC_CHAT: Agent belonging to this queue can help anything related to credit card and can speak both english and spanish.\n"
			+ "Q4_FR_CHAT: Agent belonging to this queue helps with fraudulent activity on credit card, debit card, cyber security related.\n"
			+ "\n"
			+ "Select the best queue for the customer based on the below CHAT_SUMMARY:\n"
			+ "CHAT_SUMMARY:  \"%s\""
			+ "only send the queue name without any other string";
}


package com.technocouple.richiebot.smartrouting.chat.bison.model;

import java.util.List;


public class ChatBisonResponse {
	
	private List<PredictionsChat> predictions;
	public ChatBisonResponse() {}
	public ChatBisonResponse(List<PredictionsChat> predictions) {
		super();
		this.predictions = predictions;
	}
	public List<PredictionsChat> getPredictions() {
		return predictions;
	}
	public void setPredictions(List<PredictionsChat> predictions) {
		this.predictions = predictions;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatBisonResponse [predictions=").append(predictions).append("]");
		return builder.toString();
	}
	
	
	

}

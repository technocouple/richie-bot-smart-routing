package com.technocouple.richiebot.smartrouting.text.bison.model;

import java.util.List;

public class TextBisonPredictResponse {
	
	private List<Predictions> predictions;
	public TextBisonPredictResponse() {}

	public TextBisonPredictResponse(List<Predictions> predictions) {
		super();
		this.predictions = predictions;
	}

	public List<Predictions> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<Predictions> predictions) {
		this.predictions = predictions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextBisonPredictResponse [predictions=").append(predictions).append("]");
		return builder.toString();
	}
	
	
	

}

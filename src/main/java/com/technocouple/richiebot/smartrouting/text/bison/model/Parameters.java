package com.technocouple.richiebot.smartrouting.text.bison.model;

public class Parameters {
	
	private int temperature;
	private int topK;
	private double topP;
	private int maxOutputTokens;
	
	public Parameters() {}
	public Parameters(int temperature, int topK, int topP, int maxOutputTokens) {
		super();
		this.temperature = temperature;
		this.topK = topK;
		this.topP = topP;
		this.maxOutputTokens = maxOutputTokens;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getTopK() {
		return topK;
	}
	public void setTopK(int topK) {
		this.topK = topK;
	}
	public double getTopP() {
		return topP;
	}
	public void setTopP(double topP) {
		this.topP = topP;
	}
	public int getMaxOutputTokens() {
		return maxOutputTokens;
	}
	public void setMaxOutputTokens(int maxOutputTokens) {
		this.maxOutputTokens = maxOutputTokens;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parameters [temperature=").append(temperature).append(", topK=").append(topK).append(", topP=")
				.append(topP).append(", maxOutputTokens=").append(maxOutputTokens).append("]");
		return builder.toString();
	}
	
	

}

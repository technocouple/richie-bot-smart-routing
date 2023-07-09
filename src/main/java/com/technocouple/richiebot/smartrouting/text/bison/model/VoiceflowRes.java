package com.technocouple.richiebot.smartrouting.text.bison.model;

public class VoiceflowRes {
	
	private String text;
	
	public VoiceflowRes() {}

	public VoiceflowRes(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VoiceflowRes [text=").append(text).append("]");
		return builder.toString();
	}
	
	

}

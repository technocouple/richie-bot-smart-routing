package com.technocouple.richiebot.smartrouting.text.bison.model;

public class Instances {
	
	private String content;
	
	public Instances() {};

	public Instances(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instances [content=").append(content).append("]");
		return builder.toString();
	}
	
	

}

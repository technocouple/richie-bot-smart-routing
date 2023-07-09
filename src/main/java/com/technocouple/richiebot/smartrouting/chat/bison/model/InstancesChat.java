package com.technocouple.richiebot.smartrouting.chat.bison.model;

import java.util.List;


public class InstancesChat {
	
	private String context;
	private List<Examples> examples;
	private List<Messages> messages;
	public InstancesChat() {}
	public InstancesChat(String context, List<Examples> examples, List<Messages> messages) {
		super();
		this.context = context;
		this.examples = examples;
		this.messages = messages;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public List<Examples> getExamples() {
		return examples;
	}
	public void setExamples(List<Examples> examples) {
		this.examples = examples;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstancesChat [context=").append(context).append(", examples=").append(examples)
				.append(", messages=").append(messages).append(", parameters=").append("]");
		return builder.toString();
	}
	
	

}

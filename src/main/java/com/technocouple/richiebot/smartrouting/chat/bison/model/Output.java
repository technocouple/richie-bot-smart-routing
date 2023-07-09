package com.technocouple.richiebot.smartrouting.chat.bison.model;

public class Output {
	
	private String author;
	private String content;
	public Output() {}
	public Output(String author, String content) {
		super();
		this.author = author;
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
		builder.append("Output [author=").append(author).append(", content=").append(content).append("]");
		return builder.toString();
	}
	
	

}

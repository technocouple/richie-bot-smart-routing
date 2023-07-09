package com.technocouple.richiebot.smartrouting.chat.bison.model;

public class Examples {
	
	private Input input;
	private Output output;
	public Examples() {}
	public Examples(Input input, Output output) {
		super();
		this.input = input;
		this.output = output;
	}
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Examples [input=").append(input).append(", output=").append(output).append("]");
		return builder.toString();
	}
	
	

}

package com.technocouple.richiebot.smartrouting.text.bison.model;

import java.util.List;

public class CitationMetadata {
	
	private List<String> citations;
	public CitationMetadata() {}
	public CitationMetadata(List<String> citations) {
		super();
		this.citations = citations;
	}

	public List<String> getCitations() {
		return citations;
	}

	public void setCitations(List<String> citations) {
		this.citations = citations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CitationMetadata [citations=").append(citations).append("]");
		return builder.toString();
	}
	

}

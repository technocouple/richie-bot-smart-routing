package com.technocouple.richiebot.smartrouting.text.bison.model;

public class Predictions {
	
	private String content;
	private CitationMetadata citationMetadata; 
	private SafetyAttributes safetyAttributes;
	public Predictions() {}
	public Predictions(String content, CitationMetadata citationMetadata, SafetyAttributes safetyAttributes) {
		super();
		this.content = content;
		this.citationMetadata = citationMetadata;
		this.safetyAttributes = safetyAttributes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CitationMetadata getCitationMetadata() {
		return citationMetadata;
	}
	public void setCitationMetadata(CitationMetadata citationMetadata) {
		this.citationMetadata = citationMetadata;
	}
	public SafetyAttributes getSafetyAttributes() {
		return safetyAttributes;
	}
	public void setSafetyAttributes(SafetyAttributes safetyAttributes) {
		this.safetyAttributes = safetyAttributes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Predictions [content=").append(content).append(", citationMetadata=").append(citationMetadata)
				.append(", safetyAttributes=").append(safetyAttributes).append("]");
		return builder.toString();
	}
	
	
	

}

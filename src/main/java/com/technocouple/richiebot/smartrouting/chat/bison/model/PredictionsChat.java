package com.technocouple.richiebot.smartrouting.chat.bison.model;

import java.util.List;

import com.technocouple.richiebot.smartrouting.text.bison.model.CitationMetadata;
import com.technocouple.richiebot.smartrouting.text.bison.model.SafetyAttributes;


public class PredictionsChat {
	
	private List<CitationMetadata> citationMetadata;
	private List<Candidates> Candidates;
	private List<SafetyAttributes> safetyAttributes;
	public PredictionsChat() {}
	public PredictionsChat(List<CitationMetadata> citationMetadata,
			List<Candidates> candidates,
			List<SafetyAttributes> safetyAttributes) {
		super();
		this.citationMetadata = citationMetadata;
		Candidates = candidates;
		this.safetyAttributes = safetyAttributes;
	}
	public List<CitationMetadata> getCitationMetadata() {
		return citationMetadata;
	}
	public void setCitationMetadata(List<CitationMetadata> citationMetadata) {
		this.citationMetadata = citationMetadata;
	}
	public List<Candidates> getCandidates() {
		return Candidates;
	}
	public void setCandidates(List<Candidates> candidates) {
		Candidates = candidates;
	}
	public List<SafetyAttributes> getSafetyAttributes() {
		return safetyAttributes;
	}
	public void setSafetyAttributes(List<SafetyAttributes> safetyAttributes) {
		this.safetyAttributes = safetyAttributes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PredictionsChat [citationMetadata=").append(citationMetadata).append(", Candidates=")
				.append(Candidates).append(", safetyAttributes=").append(safetyAttributes).append("]");
		return builder.toString();
	}
	
	

}

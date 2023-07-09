package com.technocouple.richiebot.smartrouting.text.bison.model;

import java.util.List;

public class SafetyAttributes {
	
	private List<String> categories;
	private boolean blocked;
	private List<String> scores;
	
	public SafetyAttributes() {}
	
	public SafetyAttributes(List<String> categories, boolean blocked, List<String> scores) {
		super();
		this.categories = categories;
		this.blocked = blocked;
		this.scores = scores;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public List<String> getScores() {
		return scores;
	}

	public void setScores(List<String> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SafetyAttributes [categories=").append(categories).append(", blocked=").append(blocked)
				.append(", scores=").append(scores).append("]");
		return builder.toString();
	}
	
	

}

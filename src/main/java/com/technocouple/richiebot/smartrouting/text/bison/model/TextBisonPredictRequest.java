package com.technocouple.richiebot.smartrouting.text.bison.model;

import java.util.List;

public class TextBisonPredictRequest {
	
	private List<Instances> instances;
	private Parameters parameters;
	
	public TextBisonPredictRequest() {}
	
	public TextBisonPredictRequest(List<Instances> instances, Parameters parameters) {
		super();
		this.instances = instances;
		this.parameters = parameters;
	}

	public List<Instances> getInstances() {
		return instances;
	}

	public void setInstances(List<Instances> instances) {
		this.instances = instances;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextBisonPredictRequest [instances=").append(instances).append(", parameters=")
				.append(parameters).append("]");
		return builder.toString();
	}
	
	

}

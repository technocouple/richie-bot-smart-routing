package com.technocouple.richiebot.smartrouting.chat.bison.model;

import java.util.List;

import com.technocouple.richiebot.smartrouting.text.bison.model.Parameters;


public class ChatBIsonRequest {
	
	private List<InstancesChat> instances;
	private Parameters parameters;
	public ChatBIsonRequest() {}
	public ChatBIsonRequest(List<InstancesChat> instances, Parameters parameters) {
		super();
		this.instances = instances;
		this.parameters = parameters;
	}
	public List<InstancesChat> getInstances() {
		return instances;
	}
	public void setInstances(List<InstancesChat> instances) {
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
		builder.append("ChatBIsonRequest [instances=").append(instances).append(", parameters=").append(parameters)
				.append("]");
		return builder.toString();
	}
	

}

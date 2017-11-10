package com.five9.search.profile.kafka.entity;

import javax.validation.constraints.NotNull;

public class HeaderObject {

	@NotNull
	private Requestor requestor;
	@NotNull
	private String operation;
	private Object params;
	public Requestor getRequestor() {
		return requestor;
	}
	public void setRequestor(Requestor requestor) {
		this.requestor = requestor;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public HeaderObject(Requestor requestor, String operation) {
		super();
		this.requestor = requestor;
		this.operation = operation;
	}
	public Object getParams() {
		return params;
	}
	public void setParams(Object params) {
		this.params = params;
	}
	public HeaderObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

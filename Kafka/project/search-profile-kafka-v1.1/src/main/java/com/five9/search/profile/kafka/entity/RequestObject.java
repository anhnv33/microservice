package com.five9.search.profile.kafka.entity;

import javax.validation.constraints.NotNull;

public class RequestObject {

	@NotNull
	private HeaderObject header;
	private Object payload;
	public HeaderObject getHeader() {
		return header;
	}
	public void setHeader(HeaderObject header) {
		this.header = header;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public RequestObject(HeaderObject header, Object payload) {
		super();
		this.header = header;
		this.payload = payload;
	}
	public RequestObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

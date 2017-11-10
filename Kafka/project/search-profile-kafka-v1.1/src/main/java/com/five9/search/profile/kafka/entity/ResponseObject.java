package com.five9.search.profile.kafka.entity;

public class ResponseObject {

	private HeaderObject header;
	private Result result;
	private Object payload;
	public HeaderObject getHeader() {
		return header;
	}
	public void setHeader(HeaderObject header) {
		this.header = header;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	public ResponseObject(HeaderObject header, Result result, Object payload) {
		super();
		this.header = header;
		this.result = result;
		this.payload = payload;
	}
	public ResponseObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

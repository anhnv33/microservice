package com.five9.search.profile.kafka.entity;

public class Result {

	private String code;
	private String message;
	private String description;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Result(String code, String message, String description) {
		super();
		this.code = code;
		this.message = message;
		this.description = description;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

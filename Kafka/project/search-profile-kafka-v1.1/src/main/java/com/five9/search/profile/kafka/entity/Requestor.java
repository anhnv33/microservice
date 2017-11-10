package com.five9.search.profile.kafka.entity;

import javax.validation.constraints.NotNull;

public class Requestor {

	@NotNull
	private String id;
	
	@NotNull
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Requestor(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Requestor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

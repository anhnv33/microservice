package com.five9.search.profile.kafka.dao;

public interface ProviderDAO {
	
	public boolean putSearchInfo(String requestId, String typeSearch, String data);

}

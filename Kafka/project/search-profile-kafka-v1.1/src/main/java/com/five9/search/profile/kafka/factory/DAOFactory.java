package com.five9.search.profile.kafka.factory;

import com.five9.search.profile.kafka.dao.ProviderDAO;

public abstract class DAOFactory {
	
	public static final String REPETITIVE_TOPIC = "repetitive-topic";
	public static final String REACTIVE_TOPIC = "reactive-topic";
	
	public abstract ProviderDAO getProviderDAO();
	
	public static DAOFactory getDAOFactory(String whichFactory) {
		switch (whichFactory) {
		case REPETITIVE_TOPIC:
			return new ProviderRepetitiveDAOFactory();
		default:
			return null;
		}
	}
	

}

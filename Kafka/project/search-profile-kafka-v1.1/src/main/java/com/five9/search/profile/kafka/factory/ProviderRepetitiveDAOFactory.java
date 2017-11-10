package com.five9.search.profile.kafka.factory;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

import com.five9.search.profile.kafka.dao.ProviderDAO;
import com.five9.search.profile.kafka.dao.ProviderRepetitiveDAO;
import com.five9.search.profile.kafka.entity.RecordKafka;

public class ProviderRepetitiveDAOFactory extends DAOFactory{
	
	public static final String TOPIC = "repetitive-topic";
	public static final String BOOTSTRAP_SERVERS = "192.168.9.61:9092, 192.168.9.63:9092, 192.168.9.64:9092";
	
	public static Properties createProperties() {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		return props;
	}
	
	@Override
	public ProviderDAO getProviderDAO() {
		return new ProviderRepetitiveDAO();
	}
	
}

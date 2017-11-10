package com.five9.search.profile.kafka.dao;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.five9.search.profile.kafka.entity.RecordKafka;
import com.five9.search.profile.kafka.factory.ProviderRepetitiveDAOFactory;

public class ProviderRepetitiveDAO implements ProviderDAO {

	private Properties properties = null;
	private Producer<String, RecordKafka> producer;

	public ProviderRepetitiveDAO() {
		properties = ProviderRepetitiveDAOFactory.createProperties();
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "com.five9.search.profile.kafka.serializers.RecordKafkaSerializer");

		producer = new KafkaProducer<String, RecordKafka>(properties);
	}

	@Override
	public boolean putSearchInfo(String requestId, String typeSearch, String data) {
		boolean returnValue = false;
		// try {
		RecordKafka record = new RecordKafka();
		record.setType(typeSearch);
		record.setValue(data);
		producer.send(new ProducerRecord<String, RecordKafka>(ProviderRepetitiveDAOFactory.TOPIC, requestId, record));
		returnValue = true;
		// } finally {
		// producer.flush();
		// producer.close();
		// }
		return returnValue;
	}

}

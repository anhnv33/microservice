package com.five9.search.profile.kafka.serializers;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.five9.search.profile.kafka.entity.RecordKafka;

public class RecordKafkaSerializer implements Serializer<RecordKafka> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, RecordKafka data) {
		byte[] returnValue = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			returnValue = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	@Override
	public void close() {

	}

}

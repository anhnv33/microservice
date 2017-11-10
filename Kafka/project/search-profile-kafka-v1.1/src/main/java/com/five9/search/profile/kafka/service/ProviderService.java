package com.five9.search.profile.kafka.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.five9.search.profile.kafka.dao.ProviderDAO;
import com.five9.search.profile.kafka.entity.RecordKafka;
import com.five9.search.profile.kafka.entity.RequestObject;
import com.five9.search.profile.kafka.entity.ResponseObject;
import com.five9.search.profile.kafka.entity.Result;
import com.five9.search.profile.kafka.factory.DAOFactory;

@Service("providerService")
public class ProviderService {

	private final String SUCCESS = "00";
	private final String EXCEPTION = "99";
	private final String MISSING_INFO = "01";
	private final String EXCEPTION_MESSAGE = "System error!";
	private final String MISSING_INFO_MESSAGE = "Missing information!";
	
	DAOFactory providerRepetitiveFactory = DAOFactory.getDAOFactory(DAOFactory.REPETITIVE_TOPIC);
	ProviderDAO providerRepetitiveDAO = providerRepetitiveFactory.getProviderDAO();
	
	public ResponseObject putRecordToKafka(RequestObject request) {
		ResponseObject response = new ResponseObject();
		Result result = new Result();
		response.setHeader(request.getHeader());
		if(request.getPayload() != null) {
			boolean resultPutRecord = false;
			String type = null;
			String value = null;
			try {
				LinkedHashMap<String, String> payload = (LinkedHashMap<String, String>)request.getPayload();
				for (Map.Entry<String, String> entry : payload.entrySet()) {
				    String key = entry.getKey();
				    String entryValue = entry.getValue();
				    
				    if(key == "type") {
				    	type = entryValue;
				    }else if (key == "value") {
				    	value = entryValue;
				    }
				}
				if(type != null && value != null) {
					resultPutRecord = providerRepetitiveDAO.putSearchInfo(request.getHeader().getRequestor().getId(), type,
							value);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(resultPutRecord) {
				result.setCode(SUCCESS);
			}else {
				result.setCode(EXCEPTION);
				result.setMessage(EXCEPTION_MESSAGE);
			}
		}else {
			result.setCode(MISSING_INFO);
			result.setMessage(MISSING_INFO_MESSAGE);
		}
		response.setResult(result);
		return response;
	}
	
}

package com.five9.search.profile.kafka.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.five9.search.profile.kafka.entity.RequestObject;
import com.five9.search.profile.kafka.entity.ResponseObject;
import com.five9.search.profile.kafka.service.ProviderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/kafka")
public class SeedKafkaProviderController {

	@Autowired
	ProviderService providerService;

	@RequestMapping(value = "/kafka_provider", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<?> provider(@Valid @RequestBody RequestObject request) {
		ResponseObject reponseObject = providerService.putRecordToKafka(request);
		return new ResponseEntity(reponseObject, HttpStatus.OK);
	}

}

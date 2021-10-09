package com.test.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.controller.model.RequestString;
import com.test.controller.model.ResponseString2IntInfo;
import com.test.function.SeperateReq;
import com.test.function.Utility;

@Controller
@RestController
@RequestMapping("/retrieve")
public class Sting2IntController {
	private final Logger log = LoggerFactory.getLogger(Sting2IntController.class);
	
	@Autowired
	Utility utility;

	@Value("${constant.convertFlag}")
	String convertFlag;
	
	private ObjectMapper om = new ObjectMapper();

	@GetMapping(value = { "/int", "/int/{inputString}" })
	public ResponseEntity<ResponseString2IntInfo> getInt(@PathVariable(required = false) String inputString) throws Exception {
		String uuid = UUID.randomUUID().toString();
		
		ResponseString2IntInfo response = new ResponseString2IntInfo();
		try {
			log.info("InputString: " + om.writeValueAsString(inputString));
			response.setTransactionId(uuid);
			if (inputString != null && (!inputString.isEmpty() || !inputString.isBlank())) {

				SeperateReq ut = utility.separateInt(inputString, convertFlag);
				response.setErrorCode("200");
				response.setMessage("Success");
				response.setIntString(ut.getIntString());
				response.setPureInt(ut.getPureInt());

				log.info("Response Int: " + om.writeValueAsString(response));
			} else {
				response.setErrorCode("500");
				response.setMessage("inputString is required.");
				log.info("Error: " + "inputString is required");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/int")
	public ResponseEntity<ResponseString2IntInfo> getIntFromSpecialCharacter(@RequestBody RequestString inputString) throws Exception {
		String uuid = UUID.randomUUID().toString();

		ResponseString2IntInfo response = new ResponseString2IntInfo();
		try {
			log.info("InputString: " + om.writeValueAsString(inputString));
			response.setTransactionId(uuid);
			if (inputString.getInputString() != null && (!inputString.getInputString().isEmpty() || !inputString.getInputString().isBlank())) {
				SeperateReq ut = utility.separateInt(inputString.getInputString(), convertFlag);

				response.setErrorCode("200");
				response.setMessage("Success");
				response.setIntString(ut.getIntString());
				response.setPureInt(ut.getPureInt());

				log.info("Response Int: " + om.writeValueAsString(response));
			} else {
				response.setErrorCode("500");
				response.setMessage("inputString is required.");
				log.info("Error: " + "inputString is required");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
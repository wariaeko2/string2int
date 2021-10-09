package com.test.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.controller.model.ResponseString2IntInfo;

//@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping("/retrieve")
public class Sting2IntController {
	private final Logger log = LoggerFactory.getLogger(Sting2IntController.class);

	private ObjectMapper om = new ObjectMapper();

	final private String separateIntRegex = "[a-zA-Zก-ฮ]|[\\\\!@#$%^&*()_+-.?<>=]";

	@GetMapping(value = { "/int", "/int/{inputString}" })
	public ResponseEntity<ResponseString2IntInfo> getUserCustomer(@PathVariable(required = false) String inputString) throws Exception {
		String uuid = UUID.randomUUID().toString();

		ResponseString2IntInfo response = new ResponseString2IntInfo();
		try {
			log.info("InputString: " + om.writeValueAsString(inputString));
			response.setTransactionId(uuid);
			String separateInt = inputString.replaceAll(separateIntRegex, "");
			
			StringBuilder sb = new StringBuilder();
			for (char chInt : separateInt.toCharArray()) {
				sb.append(chInt);
			}
			
			response.setErrorCode("200"); 
			response.setMessage("Success");
			response.setIntInfo(sb.toString());

			log.info("Response Int: " + om.writeValueAsString(response.getIntInfo()));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
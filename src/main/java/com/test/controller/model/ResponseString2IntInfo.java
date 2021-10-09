package com.test.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "transactionId", "errorCode", "message", "employeeList" })
@Getter
@Setter
@ToString
public class ResponseString2IntInfo extends ResponseInfo{
	private static final long serialVersionUID = 4394837135283578727L;

	private String intInfo;
}

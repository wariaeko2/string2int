package com.test.controller.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseInfo implements Serializable {
	private static final long serialVersionUID = -7264164227434030557L;
	
	private String transactionId;
	private String errorCode;
	private String Message;

}

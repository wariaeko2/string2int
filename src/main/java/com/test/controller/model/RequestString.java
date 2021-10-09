package com.test.controller.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestString implements Serializable{
	private static final long serialVersionUID = -241512020436015286L;
	private String inputString;

}
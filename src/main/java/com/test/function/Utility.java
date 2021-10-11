package com.test.function;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	final private String separateIntRegex = "[a-zA-Zก-ฮ]|[\\\\!@#$%^&*()_+-.?<>=/]";

	public SeperateReq separateInt(String str, String convertFlag) {
		SeperateReq resp = new SeperateReq();
		String separateInt = str.replaceAll(separateIntRegex, "");
		
		resp.setIntString(separateInt);
		
		if("Y".equals(convertFlag)) {
			resp.setPureInt(convertToInt(separateInt));
		}

		return resp;
	}
	
	public int convertToInt(String a) {
        int c = Integer.parseInt(a);
        return c;
	}
}
package com.test.function;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	final private String separateIntRegex = "[a-zA-Zก-ฮ]|[\\\\!@#$%^&*()_+-.?<>=/]";

	public SeperateReq separateInt(String str, String convertFlag) {
		SeperateReq resp = new SeperateReq();
		String separateInt = str.replaceAll(separateIntRegex, "");
		StringBuilder sb = new StringBuilder();
		for (char chInt : separateInt.toCharArray()) {
			sb.append(chInt);
		}
		
		resp.setIntString(sb.toString());
		
		if("Y".equals(convertFlag)) {
			resp.setPureInt(convertToInt(sb.toString()));
		}

		return resp;
	}
	
	public int convertToInt(String a) {
        int c = Integer.parseInt(a);
        return c;

	}
}
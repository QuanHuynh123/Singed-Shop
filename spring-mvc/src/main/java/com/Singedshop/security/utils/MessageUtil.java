package com.Singedshop.security.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	
	public Map<String,String> getMessage(String message) {
		Map<String,String> result = new HashMap<String, String>();
		if(message.equals("update_success")) {
			result.put("message","Update success");
			result.put("alert", "success");
		}else if(message.equals("insert_success")) {
			result.put("message","Insert success");
			result.put("alert", "success");
		}else if(message.equals("delete system")){
			result.put("message","Delete success");
			result.put("alert", "danger");
		}else if(message.equals("error system")){
			result.put("message","Error success");
			result.put("alert", "danger");
		}
		return result;
	}
}

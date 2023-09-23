package com.online.store.util;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
	
	
	public static ResponseEntity<HashMap<String, Object>> getResponseFormat(HttpStatus status, String message, Object data) {

		int responsestatus;
		if (status.equals(HttpStatus.OK) || status.value() == 200) {
			responsestatus = 0;
		} else {
			responsestatus = 1;
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("responsecode", responsestatus);
		map.put("messages", message);
		map.put("data", data);
		return ResponseEntity.status(status).body(map);
	}

}

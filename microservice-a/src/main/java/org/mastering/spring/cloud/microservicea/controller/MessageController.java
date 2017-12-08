package org.mastering.spring.cloud.microservicea.controller;

import java.util.HashMap;
import java.util.Map;

import org.mastering.spring.cloud.microservicea.profileUtils.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	@Autowired
	ApplicationConfiguration appConfig;
	
	@GetMapping("/message")
	public Map<String, String> welcome() {
		Map<String, String> map = new HashMap<>();
		map.put("message", appConfig.getMessage());
		return map;
	}
	
}

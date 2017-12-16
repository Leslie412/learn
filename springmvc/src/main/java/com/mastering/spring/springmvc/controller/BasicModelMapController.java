package com.mastering.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicModelMapController {
	@GetMapping("/welcome-model-map")
	public String welcome(ModelMap model) {
		model.put("name", "XYZ");
		return "welcome-model-map";
	}
}

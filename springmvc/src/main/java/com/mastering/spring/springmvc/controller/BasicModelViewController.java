package com.mastering.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicModelViewController {
	@GetMapping("/welcome-model-view")
	public ModelAndView welcome(ModelMap model) {
		model.put("name", "XYZ");
		return new ModelAndView("welcome-model-view", model);
	}
}

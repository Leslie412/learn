package com.mastering.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicViewController {
	@GetMapping("/welcome-view")
	public String welcome() {
		return "welcome";
	}
}

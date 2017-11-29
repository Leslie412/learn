package com.mastering.spring.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.springboot.bean.WelcomeBean;

@RestController
public class BasicController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello World!";
	}
	
	@GetMapping("/welcome-with-object")
	public WelcomeBean welcomeWithObject() {
		return new WelcomeBean("Hello World!");
	}
}

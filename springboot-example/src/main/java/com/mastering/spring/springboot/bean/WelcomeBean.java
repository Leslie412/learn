package com.mastering.spring.springboot.bean;

import lombok.Getter;

@Getter
public class WelcomeBean {

	private String message;

	public WelcomeBean(String message) {
		this.message = message;
	}
}

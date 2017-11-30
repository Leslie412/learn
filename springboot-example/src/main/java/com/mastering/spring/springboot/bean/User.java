package com.mastering.spring.springboot.bean;

import lombok.Getter;

@Getter
public class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String retrieveSex(String name) {
		return "male";
	}
}

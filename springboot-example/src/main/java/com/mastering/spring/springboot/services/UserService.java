package com.mastering.spring.springboot.services;

import org.springframework.stereotype.Service;

import com.mastering.spring.springboot.bean.User;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserService {
	private User user;
	
	public String retrieveUser(String name) {
		return user.retrieveSex(name);
	}
}

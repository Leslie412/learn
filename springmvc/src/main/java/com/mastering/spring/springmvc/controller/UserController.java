package com.mastering.spring.springmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mastering.spring.springmvc.Model.User;

@Controller
public class UserController {

	@GetMapping("/create-user")
	public String showCreateUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	@PostMapping("/create-user")
	public String addTodo(@Valid User user, BindingResult result) {
		System.out.println("user details: " + user);
		if(result.hasErrors()) {
			System.out.println("user information invalid");
			return "user";
		}
		return "list-users";
	}
	
	@GetMapping("/list-users")
	public String showAllUsers(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}
		return "list-users";
	}
}

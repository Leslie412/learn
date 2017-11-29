package com.mastering.spring.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.springboot.bean.Todo;
import com.mastering.spring.springboot.services.TodoService;

@RestController
public class TodoController {
	private TodoService todoService;
	
	@GetMapping("/users/{name}/todos")
	public List<Todo> retrieveTodos(@PathVariable String name) {
		return todoService.retrieveTodos(name);
	}

}

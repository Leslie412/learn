package com.mastering.spring.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mastering.spring.springboot.bean.Todo;
import com.mastering.spring.springboot.exception.TodoNotFoundException;
import com.mastering.spring.springboot.services.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/users/{name}/todos")
	public List<Todo> retrieveTodos(@PathVariable String name) {
		List<Todo> result =todoService.retrieveTodos(name); 
		return result;
	}

	@GetMapping(path = "/users/{name}/todos/{id}")
	public Resource<Todo> retrieveTodo(@PathVariable String name, @PathVariable int id) {

		Todo result = todoService.retrieveTodo(id);
		if (result == null) {
			throw new TodoNotFoundException("no such thing");
		}

		Resource<Todo> todoResource = new Resource<Todo>(result);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveTodos(name));
		todoResource.add(linkTo.withRel("parent"));

		return todoResource;
	}

	@PostMapping("/users/{name}/todos")
	ResponseEntity<?> add(@PathVariable String name, @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
		if (createdTodo == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/dummy-service")
	public Todo errorService() throws Exception {
		throw new RuntimeException("dummy service");
	}

}

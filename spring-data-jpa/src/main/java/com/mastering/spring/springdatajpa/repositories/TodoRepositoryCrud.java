package com.mastering.spring.springdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastering.spring.springdatajpa.entities.Todo;

public interface TodoRepositoryCrud extends CrudRepository<Todo, Long> {
}

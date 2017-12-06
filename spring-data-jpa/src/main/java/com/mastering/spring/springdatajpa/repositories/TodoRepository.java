package com.mastering.spring.springdatajpa.repositories;

import org.springframework.data.repository.Repository;

import com.mastering.spring.springdatajpa.entities.Todo;

public interface TodoRepository extends Repository<Todo, Long> {

	Iterable<Todo> findAll();
	long count();
}

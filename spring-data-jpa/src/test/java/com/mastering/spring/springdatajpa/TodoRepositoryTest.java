package com.mastering.spring.springdatajpa;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.springdatajpa.entities.Todo;
import com.mastering.spring.springdatajpa.repositories.TodoRepository;
import com.mastering.spring.springdatajpa.repositories.TodoRepositoryCrud;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {
	
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoRepositoryCrud todoRepositoryCrud;
	
	@Test
	public void checkTodoCount() {
		assertEquals(3, todoRepository.count());
	}
	
	@Test
	public void findOne() {
		Optional<Todo> todo = todoRepositoryCrud.findById(101L);
		assertEquals("Todo Desc 1", todo.get())
	}
}

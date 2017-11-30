package com.mastering.spring.springboot.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.BDDMockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mastering.spring.springboot.bean.Todo;
import com.mastering.spring.springboot.controller.TodoController;
import com.mastering.spring.springboot.services.TodoService;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TodoService service;

	@Test
	public void retrieveTodos() throws Exception {
		List<Todo> mockList = Arrays.asList(new Todo(1, "Jack", "Learn Spring MVC", new Date(), false),
				new Todo(2, "Jack", "Learn Struts", new Date(), false));

		BDDMockito.given(service.retrieveTodos(anyString())).willReturn(mockList);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/users/Jack/todos").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
				+ "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void retrieveTodo() throws Exception {
		Todo mockTodo = new Todo(1, "Jack", "Learn Spring MVC", new Date(), false);

		BDDMockito.when(service.retrieveTodo(anyInt())).thenReturn(mockTodo);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/users/Jack/todos/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String expected = "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void createTodo() throws Exception {
		Todo mockTodo = new Todo(5, "Jack", "Learn Spring MVC", new Date(), false);
		String todo = "{\"user\":\"Jack\",\"desc\":\"Learn Spring MVC\",\"done\":false}";

		BDDMockito.when(service.addTodo(anyString(), anyString(), isNull(), anyBoolean())).thenReturn(mockTodo);

		mvc.perform(
				MockMvcRequestBuilders.post("/users/Jack/todos").content(todo).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(MockMvcResultMatchers.header()
						.string("location", CoreMatchers.containsString(("/users/Jack/todos/5"))));
	}
}

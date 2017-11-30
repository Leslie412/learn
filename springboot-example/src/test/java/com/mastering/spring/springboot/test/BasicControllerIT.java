package com.mastering.spring.springboot.test;

import org.hamcrest.Matchers;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.springboot.Application;
import com.mastering.spring.springboot.test.util.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {

	
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate template = new TestRestTemplate();
	
	@Test
	public void welcome() throws Exception {
		ResponseEntity<String> response = template.getForEntity(Utils.createURL("/welcome", port), String.class);
		assertThat(response.getBody(), Matchers.equalTo("Hello World!"));
	}
	
	@Test
	public void welcomeWithObject() throws Exception {
		ResponseEntity<String> response = template.getForEntity(Utils.createURL("/welcome-with-object", port), String.class);
		assertThat(response.getBody(), containsString("Hello World!"));
	}
	
	@Test
	public void welcomeWithParameter() throws Exception {
		ResponseEntity<String> response = template.getForEntity(Utils.createURL("/welcome-with-parameter/name/jack", port), String.class);
		assertThat(response.getBody(), containsString("Hello World, jack"));
	}
	

}

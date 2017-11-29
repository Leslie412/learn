package com.mastering.spring.springboot.test;

import org.hamcrest.Matchers;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.springboot.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {

	private static final String LOCAL_HOST = "http://localhost:";
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate template = new TestRestTemplate();
	
	@Test
	public void welcome() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/welcome"), String.class);
		assertThat(response.getBody(), Matchers.equalTo("Hello World!"));
	}
	
	private String createURL(String uri) {
		return LOCAL_HOST + port + uri;
	}
}

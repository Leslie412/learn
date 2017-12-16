package com.mastering.spring.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mastering.spring.springmvc.controller.BasicController;

public class BasicControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController()).build();
	}

	@Test
	public void basicTest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/welcome")
						.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/html;charset=UTF-8"))
				.andExpect(content().string("welcome to spring mvc"));
	}
}

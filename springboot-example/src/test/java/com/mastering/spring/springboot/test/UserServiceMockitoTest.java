package com.mastering.spring.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mastering.spring.springboot.bean.User;
import com.mastering.spring.springboot.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockitoTest {
	@Mock
	private User dummy;

	@InjectMocks
	private UserService service = new UserService();

	@Test
	public void testUserServiceMockito() {
		BDDMockito.given(dummy.retrieveSex(ArgumentMatchers.any(String.class))).willReturn("unknown");
		
		Assert.assertEquals("unknown", service.retrieveUser("jack"));
	}
}

package com.mastering.spring.springmvc.Model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "password", "password2" })
public class User {

	private String guid;
	@Size(min = 6, message = "enter at least 6 characters")
	private String name;
	@Size(min = 6, message = "enter at least 6 characters")
	private String userId;
	private String password;
	@Size(min = 6, message = "enter at least 6 characters")
	private String password2;

	@AssertTrue(message = "password don't match")
	public boolean isValid() {
		return password.equals(password2);
	}

	public User() {

	}
}

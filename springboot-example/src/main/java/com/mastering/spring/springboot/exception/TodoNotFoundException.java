package com.mastering.spring.springboot.exception;

public class TodoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoNotFoundException(String msg) {
		super(msg);
	}
}

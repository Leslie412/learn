package com.mastering.spring.springboot.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastering.spring.springboot.exception.TodoNotFoundException;
import com.mastering.spring.springboot.util.ExceptionResponse;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TodoNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> todoNotFound(TodoNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), "some details");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> todoUnknownException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse("unknown exception happened!!", "details");
		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

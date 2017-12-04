package com.mastering.spring.springboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

	private int id;
	private String user;
	private String desc;
	
	private Date targetDate;
	private boolean isDone;
	
	public Todo() {
		
	}
	
	public Todo(int id, String user, String desc, Date targetDate, boolean isDone) {
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
}

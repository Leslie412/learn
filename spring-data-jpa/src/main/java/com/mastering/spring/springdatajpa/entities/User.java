package com.mastering.spring.springdatajpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userid;
	private String name;

	@OneToMany(mappedBy = "user")
	private List<Todo> todos;

	public User() {// Make JPA Happy
	}
}

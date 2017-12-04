package com.mastering.spring.springboot.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("db")
@Setter
@Getter
public class DBConfig {

	private String server;
	private String username;
	private String password;
}

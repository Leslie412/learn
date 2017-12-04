package com.mastering.spring.springboot.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class MainConfig {
	@Value("${spring.profiles.active}")
	private String active;
}

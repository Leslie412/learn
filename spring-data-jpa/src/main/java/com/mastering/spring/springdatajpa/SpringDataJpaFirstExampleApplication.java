package com.mastering.spring.springdatajpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaFirstExampleApplication implements ApplicationRunner {

	public static void  main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaFirstExampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(args.getSourceArgs().toString());
	}
}

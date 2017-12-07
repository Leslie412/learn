package com.mastering.spring.springdatajpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mastering.spring.springdatajpa.repositories.TodoRepository;

@SpringBootApplication
public class SpringDataJpaFirstExampleApplication implements ApplicationRunner {

	public static void  main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaFirstExampleApplication.class, args);
		TodoRepository todoRepository = context.getBean(TodoRepository.class);
		
		System.out.println("#############" + todoRepository.count());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("$$$$$$$$$$$$$$$" + args.getSourceArgs().toString());
	}
}

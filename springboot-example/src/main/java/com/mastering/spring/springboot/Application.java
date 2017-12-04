package com.mastering.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mastering.spring.springboot.profiles.DBConfig;
import com.mastering.spring.springboot.profiles.MainConfig;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MainConfig config = context.getBean(MainConfig.class);
		System.out.println("#################" + config.getActive());
		DBConfig dbconfig = context.getBean(DBConfig.class);
		System.out.println("#################" + dbconfig.getServer());
		
	}

}

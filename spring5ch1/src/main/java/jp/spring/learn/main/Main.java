package jp.spring.learn.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jp.spring.learn.beans.Data;
import jp.spring.learn.beans.User;
import jp.spring.learn.config.ApplicationConfig;
import jp.spring.learn.service.BusinessService;
import jp.spring.learn.service.BusinessServiceImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		List<Data> data = new ArrayList<>();
		data.add(new Data(1));
		data.add(new Data(2));
		data.add(new Data(3));
		data.add(new Data(4));
		data.add(new Data(5));
		
		User user = new User();
		user.setId(1);
		user.setName("Jake");
		user.setData(data);
		
		BusinessService service = context.getBean(BusinessServiceImpl.class);
		
		System.out.println(service.calculateSum(user));
	}
}

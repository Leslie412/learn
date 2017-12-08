package com.mastering.spring.consumer.serviceconsumer.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NumberAdderController {

	@Value("@{number.service.url}")
	private String numberServiceUrl;

	@RequestMapping("/add")
	public long add() {
		long sum = 0;
		ResponseEntity<Integer[]> responseEntity = (new RestTemplate()).getForEntity(numberServiceUrl, Integer[].class);

		Integer[] numbers = responseEntity.getBody();
		sum = Stream.of(numbers).reduce(0, (a1, a2) -> a1 + a2);

		return sum;
	}
}

package org.mastering.spring.cloud.microservicea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

	@RequestMapping("/random")
	public List<Long> random() {
		return Stream.generate(Math::random).map(Math::round).limit(10)
				.collect(Collectors.toCollection(ArrayList<Long>::new));
	}
}

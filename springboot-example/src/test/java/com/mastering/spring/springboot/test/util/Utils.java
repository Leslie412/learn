package com.mastering.spring.springboot.test.util;

public class Utils {

	private static final String LOCAL_HOST = "http://localhost:";
	
	public static String createURL(String uri, int port) {
		return LOCAL_HOST + port + uri;
	}
}

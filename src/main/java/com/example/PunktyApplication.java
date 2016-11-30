package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PunktyApplication {

	public static String getMessage() {
		return "Hello, world";
	}

	public static void main(String[] args) {
		SpringApplication.run(PunktyApplication.class, args);
	}
}

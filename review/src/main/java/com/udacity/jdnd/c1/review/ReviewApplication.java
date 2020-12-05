package com.udacity.jdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	public String message () {
		System.out.println("Creating message bean which has no dependencies ");
		return "Hello, Spring!";
	}

	@Bean
	public String uppercaseMessage (MessageService messageService) {
		System.out.println("Creating uppercaseMessage bean which depends on MessageService dependency");
		return messageService.uppercase();
	}

	@Bean
	public String lowercaseMessage (MessageService messageService) {
		System.out.println("Creating lowercaseMessage bean which depends on MessageService dependency");
		return messageService.lowercase();
	}
}

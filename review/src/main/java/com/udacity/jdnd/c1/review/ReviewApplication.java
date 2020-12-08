package com.udacity.jdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}


//
//	@Bean
//	public String uppercaseMessage (MessageService messageService) {
//		System.out.println("Creating uppercaseMessage bean which depends on MessageService dependency");
//		return messageService.uppercase();
//	}
//
//	@Bean
//	public String lowercaseMessage (MessageService messageService) {
//		System.out.println("Creating lowercaseMessage bean which depends on MessageService dependency");
//		return messageService.lowercase();
//	}
}

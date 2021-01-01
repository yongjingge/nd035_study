package com.udacity.course2.DogMicroservice.DogMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DogMicroserviceApplication {

//	Run together with Eureka Server to get itself registered!
	public static void main(String[] args) {
		SpringApplication.run(DogMicroserviceApplication.class, args);
	}

}

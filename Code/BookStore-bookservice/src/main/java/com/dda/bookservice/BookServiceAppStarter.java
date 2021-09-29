package com.dda.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceAppStarter {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceAppStarter.class, args);
	}
}

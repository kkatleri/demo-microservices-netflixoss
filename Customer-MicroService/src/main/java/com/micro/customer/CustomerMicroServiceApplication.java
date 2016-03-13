package com.micro.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CustomerMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroServiceApplication.class, args);
	}
}

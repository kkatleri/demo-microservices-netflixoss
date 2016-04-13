package com.micro.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
		
	@RequestMapping(value="/micro/order/{id}",
		method=RequestMethod.GET,
		produces=MediaType.ALL_VALUE)
	public String placeOrder(@PathVariable("id") int customerId){
		
		System.out.println("Hit ===> PlaceOrder");

		/*This call would only work in non-eureka environment. If Spring finds eureka related jars 
		in classpath, it tries to find localhost in Eureka registerd services and gives exception. So 
		to run using local host, all eureka and discovery client related jars needs to be removed/commented 
		in POM.xml*/
		//Object customerJson = restTemplate.getForObject("http://localhost:8080/micro/customer/{id}", Object.class,customerId);
		
		Object customerJson = restTemplate.getForObject("http://CUSTOMER-SERVICE/micro/customer/{id}", Object.class,customerId);
		
		
		System.out.println(customerJson.toString());
		
		return "false";
	}

}

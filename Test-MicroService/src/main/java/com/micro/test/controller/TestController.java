package com.micro.test.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
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

		Object[] customerJson = restTemplate.getForObject("http://localhost:8080/micro/customers", Object[].class);
		
		System.out.println(new JSONArray(customerJson).toString());
		
		return "false";
	}

}

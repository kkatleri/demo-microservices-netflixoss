package com.micro.customer.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micro.customer.model.Customer;
import com.micro.customer.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/micro/customer", 
			method = RequestMethod.POST,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println("Hit ===> createCustomer");
		customer = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/micro/customer/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long customerId) {
		System.out.println("Hit ===> getCustomer/{id}");
		Customer customer = customerService.getCustomer(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/micro/customers", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomers() {
		System.out.println("Hit ===> getAllcustomers");
		Collection<Customer> customers= customerService.getCustomers();
		return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/micro/customer", 
			method = RequestMethod.PUT,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		System.out.println("Hit ===> updateCustomer");
		customer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/micro/customer", 
			method = RequestMethod.DELETE,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) {
		System.out.println("Hit ===> deleteCustomer");
		customer = customerService.deleteCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/")
	String home(){
		return "Hello Bwoy!";
	}
	
}

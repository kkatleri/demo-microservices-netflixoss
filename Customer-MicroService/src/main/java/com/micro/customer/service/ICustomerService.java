package com.micro.customer.service;

import java.util.Collection;

import com.micro.customer.model.Customer;

public interface ICustomerService {

	Customer createCustomer(Customer customer);
	
	Customer getCustomer(long id);
	
	Collection<Customer> getCustomers();
	
	Customer updateCustomer(Customer customer);
	
	Customer deleteCustomer(Customer customer);
}

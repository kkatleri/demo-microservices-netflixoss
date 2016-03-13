package com.micro.customer.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.micro.customer.model.Customer;

@org.springframework.stereotype.Repository
public interface ICustomerRepository extends Repository<Customer, Long> {
	
	List<Customer> findAll();
	 
    Customer findOne(Long id);
 
    Customer save(Customer customer);
    
    Customer delete(Customer customer);

}

package com.micro.customer.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micro.customer.dao.ICustomerRepository;
import com.micro.customer.model.Customer;
import com.micro.customer.service.ICustomerService;

@Component("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Collection<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if(customer.getCustomerId()<=0){
			return null;
		}
		customer = customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		if(customer !=null && customer.getCustomerId()>=0){
			customer = customerRepository.delete(customer);
			return customer;
		}
		return null;
	}

}

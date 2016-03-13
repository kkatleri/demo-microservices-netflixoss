package com.metlife.gsp.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.micro.customer.CustomerMicroServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomerMicroServiceApplication.class)
@WebAppConfiguration
public class CustomerMicroServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}

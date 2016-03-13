package com.metlife.gsp.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.micro.product.ProductMicroServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductMicroServiceApplication.class)
@WebAppConfiguration
public class ProductMicroServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}

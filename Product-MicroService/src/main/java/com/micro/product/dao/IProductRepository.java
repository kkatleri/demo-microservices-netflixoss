package com.micro.product.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.micro.product.model.Product;

public interface IProductRepository extends Repository<Product, Long> {
	
	List<Product> findAll();
	 
	Product findOne(Long id);
 
	Product save(Product prodcut);
    
	Product delete(Product product);

}

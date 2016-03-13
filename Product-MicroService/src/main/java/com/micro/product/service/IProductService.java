package com.micro.product.service;

import java.util.Collection;

import com.micro.product.model.Product;

public interface IProductService {
	
	Product addProduct(Product product);
	
	Product getProduct(long id);
	
	Collection<Product> getProducts();
	
	Product updateProduct(Product product);
	
	Product removeProduct(Product product);

}

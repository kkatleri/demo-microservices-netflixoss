package com.micro.product.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micro.product.dao.IProductRepository;
import com.micro.product.model.Product;
import com.micro.product.service.IProductService;

@Component("productService")
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Collection<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		if(product.getProductId()<=0){
			return null;
		}
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Product removeProduct(Product product) {
		if(product !=null && product.getProductId()>=0){
			product = productRepository.delete(product);
			return product;
		}
		return null;
	}

}

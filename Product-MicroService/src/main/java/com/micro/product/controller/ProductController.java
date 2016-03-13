package com.micro.product.controller;

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

import com.micro.product.model.Product;
import com.micro.product.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/micro/product", 
			method = RequestMethod.POST,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		System.out.println("Hit ===> addProduct");
		product = productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/micro/product/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("id") long productId) {
		System.out.println("Hit ===> getProduct/{id}");
		Product product = productService.getProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/micro/products", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Product>> getProducts() {
		System.out.println("Hit ===> getProducts");
		Collection<Product> products= productService.getProducts();
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/micro/product", 
			method = RequestMethod.PUT,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		System.out.println("Hit ===> updateProduct");
		product = productService.updateProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/micro/product", 
			method = RequestMethod.DELETE,
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> removeProduct(@RequestBody Product product) {
		System.out.println("Hit ===> removeProduct");
		product = productService.removeProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}

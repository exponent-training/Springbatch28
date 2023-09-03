package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	void saveProductInfo(Product product);
	
	List<Product> getAllProduct();
}

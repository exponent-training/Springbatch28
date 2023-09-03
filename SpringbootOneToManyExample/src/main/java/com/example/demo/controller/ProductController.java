package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println("Check Product Data : " + product);
		productService.saveProductInfo(product);
		return ResponseEntity.ok("Product Added.");
	}
	
	@GetMapping(value = "/product/all")
	public ResponseEntity<List<Product>> getAllProduct() {
		System.out.println("Get All Product");
		List<Product> plist =  productService.getAllProduct();
		return ResponseEntity.ok(plist);
	}
}

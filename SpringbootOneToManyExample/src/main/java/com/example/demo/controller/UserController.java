package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/user/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		System.out.println("User info : " + user);
		userService.addUserData(user);
		return ResponseEntity.ok("User Added successfully.");
	}
	
	@PostMapping(value = "/buy/{id}")
	public ResponseEntity<String> buyProduct(@RequestBody Product product,@PathVariable int id) {
		System.out.println("Check id : " + id + " Product Data : " + product);
		userService.buyProduct(id, product);
		return ResponseEntity.ok("Product buy successfully.");
	}
	
	@PostMapping(value = "/buyAll/{id}")
	public ResponseEntity<String> buyProduct(@RequestBody List<Product> products,@PathVariable int id) {
		System.out.println("Check id : " + id + " Product Data : " + products);
		userService.buyProductAll(id, products);
		return ResponseEntity.ok("All Product buy successfully.");
	}
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface UserService {

	void addUserData(User user);
	
	void buyProduct(int id,Product product);

	void buyProductAll(int id,List<Product> products);
}



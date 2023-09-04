package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserByUnameAndPass(String uname, String pass) {
		// TODO Auto-generated method stub
       try {
		User user = userRepository.findByUnameAndPass(uname, pass);
	    System.out.println(user.getName());
		return user;
       }catch (Exception e) {
		// TODO: handle exception
    	   throw new UserNotFoundException("Invalid Username Adn Password.");
	   }
     
       
	}

}

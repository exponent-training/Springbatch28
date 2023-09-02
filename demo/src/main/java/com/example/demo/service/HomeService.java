package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface HomeService {

	
	void saveStudetData(Student student);
	
	List<Student> getLoginData(String uname,String pass);
}

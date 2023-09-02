package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface HomeService {

	void saveStudent(Student student);
	
	Student getLoginData(String uname,String pass);
	
	Student getDataUsingOnlyUname(String uname);
	
	List<Student> getAllStudent();
	
	Student getStudentUsingId(int id);
	
	void studentUpdating(Student student);
	
	void deleteById(int id);
}

package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface HomeDao {

	void saveStudentData(Student student);
	
	List<Student> getLoginData(String uname, String pass);
}

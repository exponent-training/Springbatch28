package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class HomeController {

	@RequestMapping(value = "/getStu")
	public Student showStudentData() {
		Student student = new Student();
		student.setId(1234);
		student.setName("Pqrs");
		student.setAddress("Pune");
		return student;
	}
	
	@RequestMapping(value = "/getStuAll")
	public List<Student> showAllStudentData() {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setId(1234);
		student.setName("Pqrs");
		student.setAddress("Pune");
		
		Student student1 = new Student();
		student1.setId(1234);
		student1.setName("Pqrs");
		student1.setAddress("Pune");
		
		Student student2 = new Student();
		student2.setId(1234);
		student2.setName("Pqrs");
		student2.setAddress("Pune");
		
		Student student3 = new Student();
		student3.setId(1234);
		student3.setName("Pqrs");
		student3.setAddress("Pune");
		
		list.add(student);list.add(student1);list.add(student2);list.add(student3);
		
		return list;
	}
	
}

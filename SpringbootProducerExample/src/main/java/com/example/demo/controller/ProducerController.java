package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class ProducerController {

	@GetMapping(value = "/get")
	public ResponseEntity<Student> getStudentData(){
		
		Student student = new Student();
		student.setId(2);student.setName("Ajas");student.setAddress("Pune");
		student.setUname("ajas.shaikh");student.setPass("ajas@321");
		
		return ResponseEntity.ok(student);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Student>> getAllStudentData(){
		
		Student student = new Student();
		student.setId(2);student.setName("Ajas");student.setAddress("Pune");
		student.setUname("ajas.shaikh");student.setPass("ajas@321");
		
		Student student1 = new Student();
		student1.setId(2);student1.setName("Ajas");student1.setAddress("Pune");
		student1.setUname("ajas.shaikh");student1.setPass("ajas@321");
		
		Student student2 = new Student();
		student2.setId(2);student2.setName("Ajas");student2.setAddress("Pune");
		student2.setUname("ajas.shaikh");student2.setPass("ajas@321");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);list.add(student1);list.add(student2);
		
		return ResponseEntity.ok(list);
	}
	
}

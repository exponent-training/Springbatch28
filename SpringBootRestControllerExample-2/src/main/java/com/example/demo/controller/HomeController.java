package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.HomeService;

@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	@PostMapping(value = "/reg")
	public String getRegisterdData(@RequestBody Student student) {
		System.out.println("Registerd Data : " + student);
		homeService.saveStudent(student);
		return "Register successfully....!";
	}
	
	@GetMapping(value = "/log")
	public Student getStudentUsingUnameAnsPass(@RequestParam String uname,@RequestParam String pass){
		System.out.println("Login Credentials : " + uname + " " + pass);
		Student student = homeService.getLoginData(uname, pass);
		return student;
	}
	
	@GetMapping(value = "/get/{uname}")
	public Student getStudentUsingUnameAnsPass(@PathVariable String uname){
		System.out.println("Uasername : " + uname );
		Student student = homeService.getDataUsingOnlyUname(uname);
		return student;
	}
	
	@GetMapping(value = "/getAll")
	public List<Student> getAllStudentData(){
		List<Student> list = homeService.getAllStudent();
		return list;
	}
	
	@GetMapping(value = "/getstu/{id}")
	public Student getSinglestudent(@PathVariable int id) {
		System.out.println("Student Id : " + id);
		Student student = homeService.getStudentUsingId(id);
		return student;
	}
	
	@PutMapping(value = "/up")
	public String studentUpdating(@RequestBody Student student) {
		homeService.studentUpdating(student);
	    return "successfully updated";
	}
	
	@DeleteMapping(value = "/del/{id}")
	public String deleteStudent(@PathVariable int id) {
		homeService.deleteById(id);
		return "successfully deleted";
	}
}

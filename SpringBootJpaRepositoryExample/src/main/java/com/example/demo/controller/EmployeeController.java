package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmpService empService;
	
	@PostMapping(value = "/save")
	public String saveEmployeeData(@RequestBody Employee employee) {
		System.out.println("Employee Data : " + employee);
		empService.saveEmployee(employee);
		return "Save Successfully.";
	}
}

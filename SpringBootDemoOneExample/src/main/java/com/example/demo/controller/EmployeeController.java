package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/reg")
	public String getRegisteredData(@ModelAttribute Employee employee) { 
		System.out.println("Employee Data : " +employee);
		employeeService.saveEmployeeData(employee);
		return "index";
	}
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void saveEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Employee In Service  : " + employee);
		employeeDao.saveEmployeeData(employee);
	}

}

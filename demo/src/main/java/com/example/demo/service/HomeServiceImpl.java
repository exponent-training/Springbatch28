package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HomeDao;
import com.example.demo.entity.Student;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;
	
	@Override
	public void saveStudetData(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer : " +student);
		homeDao.saveStudentData(student);
	}

	@Override
	public List<Student> getLoginData(String uname, String pass) {
		// TODO Auto-generated method stub

		return homeDao.getLoginData(uname, pass);
	}

}

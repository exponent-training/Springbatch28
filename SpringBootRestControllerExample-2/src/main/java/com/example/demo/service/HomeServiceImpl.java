package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer : " + student);
		studentRepository.save(student);
	}

	@Override
	public Student getLoginData(String uname, String pass) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findByUnameAndPass(uname, pass);
		return student;
	}

	@Override
	public Student getDataUsingOnlyUname(String uname) {
		// TODO Auto-generated method stub
		return studentRepository.findByUname(uname);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> list = (List<Student>) studentRepository.findAll();
		return list;
	}

	@Override
	public Student getStudentUsingId(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public void studentUpdating(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}

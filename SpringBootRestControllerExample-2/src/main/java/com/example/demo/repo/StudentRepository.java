package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByUnameAndPass(String uname,String pass);
	
	Student findByUname(String uname);
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Student;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/consume")
	public ResponseEntity<Student> getSConsumedStudentData() {

		Student student = restTemplate.getForEntity("http://localhost:9000/get", Student.class).getBody();
		return ResponseEntity.ok(student);
	}

	@GetMapping(value = "/consumedata")
	public ResponseEntity<Student> getSConsumedStudent() {

		ResponseEntity<Student> responseEntity = restTemplate.getForEntity("http://localhost:9000/get", Student.class);
		return responseEntity;
	}
	
	@GetMapping(value = "/getconsumedata")
	public ResponseEntity<Student> getSConsumedStudentSingle() {

		Student student = restTemplate.getForObject("http://localhost:9000/get", Student.class);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping(value = "/getAllconsumedata")
	public ResponseEntity<List<Student>> getAllConsumedStudent() {

		List<Student> liststudent = restTemplate.getForObject("http://localhost:9000/getAll", List.class);
		return ResponseEntity.ok(liststudent);
	}
	
	@GetMapping(value = "/getAllconsumedatasecond")
	public ResponseEntity<?> getAllConsumedStudentData() {

		List<?> liststudent = restTemplate.getForEntity("http://localhost:9000/getAll", List.class).getBody();
		return ResponseEntity.ok(liststudent);
	}
}

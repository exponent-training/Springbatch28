package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringbootJsonToJavaAndJavaToJsonExampleApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(SpringbootJsonToJavaAndJavaToJsonExampleApplication.class, args);
		
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		System.out.println("=========================  Json To Java Conversion ==========================");
	
	    String  str = "{\"id\":1,\"name\":\"Abcd\",\"address\":\"Pune\",\"company\":{\"city\":\"PCMC\",\"dist\":\"Pune\"}}";
	    System.out.println("Json Data : " + str);
	    
	    Employee employee = objectMapper.readValue(str, Employee.class);
	    System.out.println("After Java Conversion : " + employee);
	    
		System.out.println("=========================  Java To Json Conversion ==========================");

		String str1 = objectMapper.writeValueAsString(employee);
		System.out.println(str1);
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/emp/save")
	public String saveLoginDataWithEmployee(@RequestBody Login login) {
		System.out.println("Login Data : " + login);
		loginService.saveLoginData(login);
		return "Successfully added....!";
	}
	
	@GetMapping(value = "/emp/get")
	public ResponseEntity<?> getloginData(@RequestParam String uname,@RequestParam String pass){
		System.out.println("ogin Credentials : " + uname + " " + pass);
		Login login = loginService.getLoginDetails(uname, pass);
		if(login != null) {
		return ResponseEntity.ok(login);
		}else {
		return ResponseEntity.ok("Invalid Username and Password.");
		}
	}
}

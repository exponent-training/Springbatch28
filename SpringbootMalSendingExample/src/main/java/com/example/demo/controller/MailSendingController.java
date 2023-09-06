package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSendingController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping(value = "/send")
	public String sendMailApi() {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("ajasshaikh8390@gmail.com");
		simpleMailMessage.setSubject("Java Mail Send Api Test.");
		simpleMailMessage.setText("THis is only Educational Purpose Java mail Send Example.");
		
		javaMailSender.send(simpleMailMessage);
		
		return "Mail Send Successfully.";
	}
}

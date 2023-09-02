package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/")
	public String getIndexPage() {
		
		return "index";
	}
	
	@RequestMapping(value = "/log")
	public String getLogiinData(@RequestParam String uname,@RequestParam String pass,Model model) {
		System.out.println("Login Credentials : " + uname + " " + pass);
		List<Student> slist = homeService.getLoginData(uname, pass);
		if(slist.size() > 0 ) {
		model.addAttribute("list", slist);
		return "success";
		} else {
			model.addAttribute("msg", "Invalid username and password.");
			return "index";
		}
	}

	@RequestMapping(value = "/reg")
	public String getRegisteredData(@ModelAttribute Student student) {
		System.out.println("Data Check : " + student);
		homeService.saveStudetData(student);
		return "index";
	}
}

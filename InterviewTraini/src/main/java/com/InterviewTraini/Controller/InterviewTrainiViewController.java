package com.InterviewTraini.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.InterviewTraini.Models.User;
import com.InterviewTraini.Services.InterviewTrainiService;

@Controller
@RequestMapping("/InterviewTraini")
public class InterviewTrainiViewController {
	
	@Autowired
	InterviewTrainiService interviewTrainiService;
	
	@GetMapping("/")
	public String view() {
		return "InterviewTraini";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String admin(@RequestParam String email, @RequestParam String password) {
		if(email=="" || password=="") {
			return "false";
		}
		else {
			User admin=interviewTrainiService.admin(email,password);
			if(admin != null) {
				return "admin";
			}
			else {
				return "NoData";
			}
		}
		
	}
}

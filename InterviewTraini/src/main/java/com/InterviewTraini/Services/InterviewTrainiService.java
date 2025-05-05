	package com.InterviewTraini.Services;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.InterviewTraini.Models.InterviewContent;
import com.InterviewTraini.Models.User;
import com.InterviewTraini.Repository.InterviewTrainiRepository;
import com.InterviewTraini.Repository.InterviewTrainiUserRepository;
	
	@Service
	public class InterviewTrainiService {
		
		@Autowired
		private InterviewTrainiRepository interviewTrainiRepository;
		
		@Autowired
		private InterviewTrainiUserRepository interviewTrainiUserRepository;
		
		public InterviewContent addContent(InterviewContent interviewContent) {
			return interviewTrainiRepository.save(interviewContent);
		}
		
		public User admin(String email,String password) {
			return interviewTrainiUserRepository.findByEmailAndPassword(email, password);
		}

	}

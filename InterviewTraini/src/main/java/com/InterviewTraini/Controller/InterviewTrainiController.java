package com.InterviewTraini.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.InterviewTraini.Models.InterviewContent;
import com.InterviewTraini.Services.InterviewTrainiService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/InterviewTraini")
public class InterviewTrainiController {

	@Autowired
	private InterviewTrainiService interviewTrainiService;
	
	@Transactional
	@PostMapping("/add-new")
	public ResponseEntity<InterviewContent> addContent(@Valid
            @RequestPart("question") String question,
            @RequestPart("answer") String answer,
            @RequestPart("title") String title,
            @RequestPart("file") MultipartFile file) {
			
			int flag=1;
			
			if(question == "" || answer == "" || title == "") {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
		try {
			// Handle the file here, for example, save it to a directory
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("src/main/resources/static/questionImages/" + fileName);
            Files.write(path, file.getBytes());
			
						
			InterviewContent interviewContent = new InterviewContent();
            interviewContent.setQuestion(question);
            interviewContent.setAnswer(answer);
            interviewContent.setTitle(title);
            interviewContent.setImage(fileName);
			InterviewContent content=this.interviewTrainiService.addContent(interviewContent);
			return ResponseEntity.of(Optional.of(content));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}

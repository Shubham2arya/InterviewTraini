package com.InterviewTraini.Models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="InterviewContent")
public class InterviewContent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@NotEmpty(message="Question, Answer & Title must be filled out.")
	private String title;
	
	@Column(name = "question", length = 3000)
	@NotEmpty(message="Question, Answer & Title must be filled out.")
	private String question;
	
	@Column(name = "answer", length = 5000)
	@NotEmpty(message="Question, Answer & Title must be filled out.")
	private String answer;
	
	private String image;
	
	  // Getter and Setter for image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

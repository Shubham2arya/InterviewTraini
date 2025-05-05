package com.InterviewTraini.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	private int id;
	
	@NotEmpty(message="email cann't be null.")
	
	private String email;
	@NotEmpty(message="password cann't be null")
	private String password;
}

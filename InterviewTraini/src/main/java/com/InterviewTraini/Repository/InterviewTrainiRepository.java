package com.InterviewTraini.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.InterviewTraini.Models.InterviewContent;
import com.InterviewTraini.Models.User;


public interface InterviewTrainiRepository extends CrudRepository<InterviewContent, Integer> {
	
	 @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	 User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}

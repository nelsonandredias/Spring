package com.java.springbootsrestbasics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Return a response status of "" when a user is not found 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7849242197803118553L;

	public UserNotFoundException(String message) {
		super(message);	
		
	}
	
	

}

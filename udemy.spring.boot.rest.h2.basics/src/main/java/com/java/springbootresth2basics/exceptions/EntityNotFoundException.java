package com.java.springbootresth2basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Return a response status of "" when an entity is not found 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4257730439038906156L;
	
	public EntityNotFoundException(String message) {
		
		super(message);
	}

}

package com.java.learning.springboot.restbasic.exceptions;


public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5447943234187561158L;

	public EntityNotFoundException (String message) {
		
		super(message );
		
	}
	
}

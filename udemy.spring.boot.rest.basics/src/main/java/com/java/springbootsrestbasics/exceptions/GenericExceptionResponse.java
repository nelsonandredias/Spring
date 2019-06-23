package com.java.springbootsrestbasics.exceptions;

import java.util.Date;

//Create a custom exception response structure

public class GenericExceptionResponse {

	//Generic Exception Structure to return every time there is an error:
	/*
	 1. timestamp
	 2. message
	 3. detail
	*/
	
	private Date timestamp;
	
	private String message;
	
	private String details;

	public GenericExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}

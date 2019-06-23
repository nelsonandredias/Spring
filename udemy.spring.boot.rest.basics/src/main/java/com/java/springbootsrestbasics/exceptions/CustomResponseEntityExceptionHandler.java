package com.java.springbootsrestbasics.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice -> allow this custom exception handler to be be applied to all controllers
//@RestController -> it is used to retrieve a response back in case of exceptions
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	//Override ResponseEntityExceptionHandler method to INTERNAL ERROR 500
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		//everytime an exception happens, we create a generic exception response instance
		/*
		 	ex.getMessage() -> get the message from the exception
		 */
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(genericExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//Override ResponseEntityExceptionHandler method to USER NOT FOUND ERROR 404
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
			
		//everytime an exception happens, we create a generic exception response instance
		/*
	 	ex.getMessage() -> get the message from the exception
		 */
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(genericExceptionResponse, HttpStatus.NOT_FOUND);
			
	}
		
	//Override ResponseEntityExceptionHandler method to USER BAD REQUEST ERROR 404
	@Override
	protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,                                     
            final HttpHeaders headers, 
            final HttpStatus status, 
            final WebRequest request) {

		//everytime an exception happens, we create a generic exception response instance
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), "Incoming Request Validation failed", ex.getBindingResult().toString());
				
		return new ResponseEntity(genericExceptionResponse, HttpStatus.BAD_REQUEST);

	}
	
}


package com.java.springbootresth2basics.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//@ControllerAdvice -> allow this custom exception handler to be be applied to all controllers
//@RestController -> it is used to retrieve a response back in case of exceptions
@RestController
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	//Override ResponseEntityExceptionHandler method to INTERNAL SERVER ERROR 500
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		
		customErrorMessage = createCustomErrorMessage(details, "Server Error!", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<Object>(customErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Override ResponseEntityExceptionHandler method to Entity NOT FOUND ERROR 404
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
		
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		
		customErrorMessage = createCustomErrorMessage(details, "Record not found!", HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<Object>(customErrorMessage, HttpStatus.BAD_REQUEST);
	}
	
	//Override ResponseEntityExceptionHandler method to Valid Entity BAD REQUEST ERROR 400
	@Override
	protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,                                     
					final HttpHeaders headers, 
					final HttpStatus status, 
					final WebRequest request) {

		//everytime an exception happens, we create a generic exception response instance
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		
		List<String> details = new ArrayList<>();
		details.add(ex.getBindingResult().toString());
		
		customErrorMessage = createCustomErrorMessage(details, "Incoming Request Validation failed", HttpStatus.BAD_REQUEST.value());
					
		return new ResponseEntity<Object>(customErrorMessage, HttpStatus.BAD_REQUEST);

	}
	
	//method that creates custom Error Message log
	public CustomErrorMessage createCustomErrorMessage(List<String> details, String errorMessage, int status) {
		
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();

		customErrorMessage.setDetails(details);
		customErrorMessage.setMessage(errorMessage);
		customErrorMessage.setStatus(status);
		customErrorMessage.setTimestamp(new Date());
		
		return customErrorMessage;
		
	}
	
	
}

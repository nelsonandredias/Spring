package com.java.learning.springboot.restbasic.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalAppolicationExceptionHandler extends ResponseEntityExceptionHandler{

	//Override ResponseEntityExceptionHandler method to Valid Entity BAD REQUEST ERROR 400
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
		
		CustomErrorMessage customError = new CustomErrorMessage();
		
		List<String> details = new ArrayList<>();
		
		details.add(ex.getMessage());
		
		customError.setDetails(details);
		customError.setMessage(ex.getLocalizedMessage());
		customError.setStatus(HttpStatus.BAD_REQUEST.value());
		customError.setTimestamp(new Date());
		
		return new ResponseEntity<Object>(customError, HttpStatus.BAD_REQUEST);
	}
	
}

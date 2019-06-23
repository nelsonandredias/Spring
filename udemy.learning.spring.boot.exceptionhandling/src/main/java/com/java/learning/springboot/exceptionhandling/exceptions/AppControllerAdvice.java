package com.java.learning.springboot.exceptionhandling.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

	//Handle type of Exceptions "Exception" and push it to the view "error"
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex, Model model) {
			
		model.addAttribute("exception", ex);
		return "errorHandler";		
	}
	
}

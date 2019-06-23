package com.java.learning.springboot.exceptionhandling.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.learning.springboot.exceptionhandling.models.Post;

@Controller
@RequestMapping("/posts")
public class PostController {

	Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@GetMapping("/get/{slug}")
	public String getPost(@PathVariable String slug ) throws Exception {
		
		Post post = null;
		
		if(post == null) {

			throw new Exception ("Unable to find post with slug " + slug);

		}
		
		return "post";
	}
	
	//Handle type of Exceptions "Exception" at the controller level and push it to the view "error"
	/*@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex, Model model) {
		
		model.addAttribute("errorMessage", ex.getMessage());
		
		return "postError";
		
	}*/
	
}

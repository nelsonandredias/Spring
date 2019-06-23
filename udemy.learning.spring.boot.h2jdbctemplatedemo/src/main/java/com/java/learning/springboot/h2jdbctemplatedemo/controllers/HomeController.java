package com.java.learning.springboot.h2jdbctemplatedemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.learning.springboot.h2jdbctemplatedemo.models.Post;
import com.java.learning.springboot.h2jdbctemplatedemo.services.PostService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		Post latestPost = postService.getLatestPost();
		
		//send current post back to the model
		model.addAttribute("post", latestPost);
		
		return "index";
		
	}
	
}

package com.java.springboot.h2.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.h2.demo.entities.Post;
import com.java.springboot.h2.demo.services.PostServiceImp;

//@RestController
@Controller
public class homeController {

	
	private PostServiceImp postServiceImp;
	
	@Autowired
	public homeController(PostServiceImp postServiceImp) {
		this.postServiceImp = postServiceImp;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		//send the current post back to the model
		model.addAttribute("post", postServiceImp.getLatestPost());
		return "index.html";
	}
	
	
}

package com.java.springboot.oracle.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.oracle.demo.entities.Author;
import com.java.springboot.oracle.demo.services.AuthorServiceImp;

@RestController
public class homeController {


	private AuthorServiceImp authorServiceImp;
	
	@Autowired
	public homeController(AuthorServiceImp authorServiceImp) {
		this.authorServiceImp = authorServiceImp;
	}
	
	@RequestMapping("/")
	public List<Author> home(Model model) {
		//get all authors
		return authorServiceImp.getAllAuthor();

	}
	
	
}

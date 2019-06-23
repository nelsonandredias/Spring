package com.java.springbootfirstexample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {

	@RequestMapping("/")
	public String home() {
		return "Hello to the homepage";
	}
}

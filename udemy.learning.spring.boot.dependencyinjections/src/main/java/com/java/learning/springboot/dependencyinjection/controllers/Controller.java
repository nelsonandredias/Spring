package com.java.learning.springboot.dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.learning.springboot.dependencyinjection.services.NotificationService;

/*
 * Dependency Injection is the process of spring manage dependencies for us, it means
 * that spring is the responsible to create bean instances for us.
 * Beans are @components, @services, @controllers, @beans for instance
 * */

@RestController
public class Controller {

	
	//Different ways of doing dependency injection:
	
	//1. Property based injection
	@Autowired
	private NotificationService notificationService;
	
	//2. Setter based injection
	//private Service service
	//@Autowired
	//public void setService(Service service) {
	//	this.service = service;
	//}
	
	//3. Constructor based injection
	//private Service service;
	//@Autowired
	//public Controller(Service service){
	//	this.service = service;
	//}
	
	@GetMapping("/home")
	public String sendMessage() {
		
		return notificationService.send();
		
	}
	
	
	
}

package com.java.learning.springboot.ymlfile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.learning.springboot.ymlfile.services.NotificationService;

/*
 * Dependency Injection is the process of spring manage dependencies for us, it means
 * that spring is the responsible to create bean instances for us.
 * Beans are @components, @services, @controllers, @beans for instance
 * */

/*@ConfigurationProperties: useful to map properties to POJOs and therefore easily control the current environmental variables (DEV, SIT, UAT, PROD).
 * @ConfigurationProperties is to workaround to avoid using infinite @Value annotation all over the code.
 * Instead:
 * 1. In the main class, we must enable/add the annotation @EnableConfigurationProperties 
 * 2. In our configuration POJO, we must add the annotation @ConfigurationProperties
 * */

@RestController
public class Controller {

	
	//1. Property based injection
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/home")
	public String sendMessage() {
		
		return "homepage";
		
	}
	
	@GetMapping("/home/send")
	public String sendNotification() {
		
		return notificationService.send();
		
	}
	
	@GetMapping("/home/sendAsync")
	public String sendAsyncNotification() {
		
		return notificationService.sendAsync();
		
	}
	
}

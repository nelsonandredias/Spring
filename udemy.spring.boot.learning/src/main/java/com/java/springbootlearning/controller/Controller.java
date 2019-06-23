package com.java.springbootlearning.controller;

import javax.xml.bind.helpers.NotIdentifiableEventImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootlearning.NotificationService.NotificationService;

@RestController
public class Controller {

	@Value("${spring.profiles.active}")
	private String pageControllerMsg;
	
	@Value("${my.secret}")
	private String mySecret;
	
	@Value("${msg}")
	private String message;
	
	//property based injection (dependency injection)- not recommended because of testing
	/*@Autowired
	private NotificationService notificationService;*/
	
	//setter based injection (dependency injection)
	/*private NotificationService notificationService;
	@Autowired
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}*/
	
	//constructor based injection (dependency injection)
	private NotificationService notificationService;
	@Autowired
	public Controller(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@RequestMapping(value="/")
	public String hello() {
		return notificationService.toString();
	}
	
	@RequestMapping(value="/default")
	public String home() {
		return pageControllerMsg;
	}
	
	@RequestMapping(value="/secret")
	public String secret() {
		return mySecret;
	}
	
	@RequestMapping(value="/message")
	public String msg() {
		return message;
	}
}

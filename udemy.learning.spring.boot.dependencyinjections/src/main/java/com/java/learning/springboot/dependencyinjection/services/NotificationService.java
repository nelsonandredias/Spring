package com.java.learning.springboot.dependencyinjection.services;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	public String send() {
		return "sendMethod";
	}
	
	public String sendAsync() {
		return "sendAsyncMethod";
		
	}
	
}

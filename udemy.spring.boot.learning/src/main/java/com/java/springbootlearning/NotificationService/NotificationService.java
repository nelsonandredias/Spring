package com.java.springbootlearning.NotificationService;

import org.springframework.stereotype.Service;

// spring bean is a component that spring will manage for us 
@Service
public class NotificationService {

	public NotificationService() {
		
	}
	
	public void sendAsync(){
		
	}
	
	@Override
	public String toString() {
		return "We are in NotificationService()";
	}
	
}

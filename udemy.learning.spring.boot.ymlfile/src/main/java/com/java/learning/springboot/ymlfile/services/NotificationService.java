package com.java.learning.springboot.ymlfile.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.java.learning.springboot.ymlfile.configurations.ConfigProperties;

@Service
public class NotificationService {

	//inject dependency of yaml properties class models
	@Autowired
	private ConfigProperties configProperties;
	
	public String send() {
		return "SendMethod: " + configProperties.getAppDescription();
	}
	
	public String sendAsync() {
		return "sendAsyncMethod: " + configProperties.getAppDescription();
		
	}
	
}

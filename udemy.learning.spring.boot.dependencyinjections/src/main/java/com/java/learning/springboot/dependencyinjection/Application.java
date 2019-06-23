package com.java.learning.springboot.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.java.learning.springboot.dependencyinjection.models.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		
		//get all application Beans
		for (String appBean : appContext.getBeanDefinitionNames()) {
					
			System.out.println(appBean);
		}
		
		System.out.println("user bean : " + appContext.getBean("user").toString());
	}

	
	//Create a Bean that will be manage by applicationContext
	@Bean
	public User user() {
		
		return new User("Nelson","Dias");
	} 
	
}

package com.java.springbootepisodezero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		//get all application Beans
		for (String appBean : applicationContext.getBeanDefinitionNames()) {
			
			System.out.println(appBean);
		}
	}

}


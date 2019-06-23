package com.java.springbootlearning;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.java.springbootlearning.models.Users;

//@ComponentScan("com.java.springbootlearning.NotificationService") //include packages that we want to scan
@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	//bean that is going to be managed by the application context (appCx)
	@Bean
	public Users userr() {
		return new Users("nelson", "dias");
	}
	
	public static void main(String[] args) {
		ApplicationContext appCx = SpringApplication.run(Application.class, args);
		
		String[] beanNames = appCx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String name: beanNames) {
			System.out.println("bean name is = " + name);
		}
		
		System.out.println(appCx.getBean("userr").toString());
		
		MyAppConfig config = (MyAppConfig) appCx.getBean("myAppConfig");
		System.out.println(config.toString());
	
		System.out.println(appCx.getBean("dataSource").toString());
	}
}

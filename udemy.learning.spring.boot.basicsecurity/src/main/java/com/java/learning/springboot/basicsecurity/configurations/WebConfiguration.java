package com.java.learning.springboot.basicsecurity.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

	/* it allows to create a preconfigured and automated controller("login") that will send us to view "login", which is saved within auth folder*/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		 //this will map uri to "login" view, which is within auth folder, directly without a controller
	     registry.addViewController("/login")
	              .setViewName("auth/login");
	     registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	
	
}

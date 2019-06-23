package com.java.learning.springboot.errorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class Application {
	
	//add custom error pages to the tomcat servlet
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> sessionManagerCustomizer() {
	   
	        return ( server -> {
				ErrorPage custom404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/404");
				server.addErrorPages(custom404Page);
			});
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

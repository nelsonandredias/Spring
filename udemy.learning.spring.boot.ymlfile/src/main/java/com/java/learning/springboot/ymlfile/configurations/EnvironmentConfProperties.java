package com.java.learning.springboot.ymlfile.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//Environment Configuration class

@Configuration
public class EnvironmentConfProperties {
	
	
	@Bean
	@Profile("development")
	ConfigProperties configDEV() {
		return new ConfigProperties();	
	}
	
	@Bean
	@Profile("integration")
	ConfigProperties configINT() {
		return new ConfigProperties();
	}

}

package com.java.springbootlearning.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java.springbootlearning.models.DataSource;

@Configuration
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@Profile("development")
	DataSource development() {
		return new DataSource("my-dev-url", 9999);
	}
	
	@Bean(name = "dataSource")
	@Profile("production")
	DataSource production() {
		return new DataSource("my-prod-url", 9999);
	}
	
}

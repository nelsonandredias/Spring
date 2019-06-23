package com.java.springbootsinternationalizationbasics.configurations;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class internationalizationConfiguration {
	
	//1. Set a default local Resolver to English-US
	@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		//set a default local Resolver
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
		
	}
	
	//3 allows to read the internationalization file properties and customise them based on the request header
	//this configuration is not needed if we use LocaleContextHolder in the controller method
	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		//define the base name of the internationalization message file properties: "messages"
		//messageSource.setBasename("static/internationalization/messages");
		messageSource.setBasename("messages");
		
		return messageSource;
		
	}*/
}

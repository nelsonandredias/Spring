package com.java.springbootsinternationalizationbasics.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootsinternationalizationbasics.configurations.internationalizationConfiguration;

@RestController
public class internationalizationController {

	/*Internationalization: it allows to customizing our services for different people around the world (diff languages)
		For that, we need:
		1. To configure LocaleResolver with a default Locale : Locale.US
		2. In resource, create property files with a list of properties that will be internationalized
		2. Configure a ResourceBundleMessageSource: allows to read the internationalization file properties and customise them based on the request header
		3. Use @Autowire MessageSource to call the ResourceBundleMessageSource
		4. Use @RequestHeader to pass the service client locale via the value of "Accept-Language". Otherwise, it is set the default (required=false)
	*/
	
	//3. Use Autowire MessageSource to call the ResourceBundleMessageSource
	@Autowired
	private MessageSource messageSource;
	
	
	//4. Use @RequestHeader to pass the service client locale via the value of "Accept-Language". Otherwise, it is set the default (required=false)
	@GetMapping("hello-world-internationalized-option1")
	public String helloWorldInternationalization(
			@RequestHeader(name="Accept-Language", required=false) Locale clientLocale) {
		//set as argument the name of the internationalization property and the service client locale
		return messageSource.getMessage("good.morning.message", null, clientLocale);
	}

	//LocaleContextHolder -> easier way of implementing internationalization
	@GetMapping("hello-world-internationalized-option2")
	public String helloWorldInternationalization() {
		//set as argument the name of the internationalization property and the service client locale
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}

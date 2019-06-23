package com.java.learning.springboot.internationalization.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

	//Use Autowire MessageSource to call the ResourceBundleMessageSource
	@Autowired
	private MessageSource messageSource;
	
	//Model class allow us to add attributes and push them to the returned view
	
	@RequestMapping("/")
	public String list(Model model) {
		//set as argument the name of the internationalization property and the service client locale
		model.addAttribute("copyright", messageSource.getMessage("copyright", null, LocaleContextHolder.getLocale()));
		return "views/list";
	}
	
}

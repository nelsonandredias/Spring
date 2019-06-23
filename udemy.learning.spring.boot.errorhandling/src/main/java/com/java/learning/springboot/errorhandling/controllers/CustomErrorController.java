package com.java.learning.springboot.errorhandling.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;


@Controller
public class CustomErrorController implements ErrorController{

	private static final String ERROR_PATH = "/error";
	private static final String ERROR_TEMPLATE = "customError";
	private static final String ERROR_PATH_404 = "/404";
	private static final String ERROR_TEMPLATE_404 = "404";
	
	@Autowired
	private ErrorAttributes errorAttributes;

	// get a map of error attributes, pass all them to a model object and push it to the view "customError"
	@RequestMapping(ERROR_PATH)
	public String error(Model model, HttpServletRequest request, WebRequest webRequest) {
		
		// {error={timestamp=Mon Nov 02 12:40:50 EST 2015, status=404, error=Not Found, message=No message available, path=/foo}}
		Map<String,Object> error =  getErrorAttributes(request, webRequest, true);;
		
		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("status", error.get("status"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", error.get("path"));
		
		return ERROR_TEMPLATE;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
	// get a map of error attributes, pass all them to a model object and push it to the view "404"
	@RequestMapping(ERROR_PATH_404)
	public String pageNotFound(Model model, HttpServletRequest request, WebRequest webRequest) {
		
		model.addAttribute("error", getErrorAttributes(request, webRequest, true));
		
		return ERROR_TEMPLATE_404;
	}
	
	// Returns a Map of the error attributes. The map can be used as the model of an error page ModelAndView, or returned as a ResponseBody.
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest,
            boolean includeStackTrace) {

		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
	
	}
	
}

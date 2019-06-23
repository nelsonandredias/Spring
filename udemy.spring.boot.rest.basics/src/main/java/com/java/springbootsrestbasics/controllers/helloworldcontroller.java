package com.java.springbootsrestbasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootsrestbasics.models.HelloWorldBean;

@RestController
public class helloworldcontroller {

	/*Always define:
	 	1. A method (GET, POST, DELETE)
	 	2. A URI
	 */
	@GetMapping("/hello-world")
	public String helloWorld () {
		return "Hello World";
	}
	
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		HelloWorldBean helloWorldBean = new HelloWorldBean("Hello World Bean");
		return helloWorldBean;
	}
	
	// @PathVariable annotation binds a URI template variable to a method parameter in a controller
	@GetMapping("hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		HelloWorldBean helloWorldBean = new HelloWorldBean(String.format("Hellow World, %s", name));
		
		return helloWorldBean;
		
	}
	
	
}

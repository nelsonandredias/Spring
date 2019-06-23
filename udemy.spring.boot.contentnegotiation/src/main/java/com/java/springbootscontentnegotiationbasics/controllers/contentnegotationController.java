package com.java.springbootscontentnegotiationbasics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootscontentnegotiationbasics.DAOservices.UserService;
import com.java.springbootscontentnegotiationbasics.models.User;

/*Content Negotiation:
  allows to retrieve a REST web services response in different formats:
 1. JSON (default)
  2. XML
 For that, add a JACKSON dependency to the pom file that allow us to handle XML conversion: jackson-dataformat-xml
 	<dependency>
    	<groupId>com.fasterxml.jackson.dataformat</groupId>
    	<artifactId>jackson-dataformat-xml</artifactId>
	</dependency> 
 */


@RestController
public class contentnegotationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		List<User> users = userService.findAll();
		
		return users;	
		
	}
	
}

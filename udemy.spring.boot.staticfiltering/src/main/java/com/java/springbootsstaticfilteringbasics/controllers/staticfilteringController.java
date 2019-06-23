package com.java.springbootsstaticfilteringbasics.controllers;


import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.springbootsstaticfilteringbasics.DAOservices.UserService;
import com.java.springbootsstaticfilteringbasics.models.User;

/*Static Filtering for rest services:
  Prevents a certain property to be part of the response. 
  Basically, just sends specific details depending of our type of end consumer.
 
	Why should we use static filtering?
	For instance, depending on the role in the session (admin or user), we must return
	a different response.
	
	Admin Response:
		id
		email
		fullName
		password
		secretKey
		
	User Response:
		email
		fullName
	
	How to set a static filter to a response property?
	There are 2 ways:
	1. set a @JsonIgnore, in each User model property, that we dont want to be part of the response
		@JsonIgnore
		private Date birthdate;
	2. or set a @JsonIgnoreProperties(value={"birthdate","id"}), to the model class, with all the class
		properties that we want to exclude from the response
	
	
 */


@RestController
public class staticfilteringController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		List<User> users = userService.findAll();
		
		return users;	
		
	}
	
	//2. resource retrieveUser
		@GetMapping("/users/{id}")
		public User retrieveUser(@PathVariable int id){
			
			User user = userService.findUserByID(id);
						
			return user;
		}
		
		//3. resource createUser
		/*
		 * @RequestBody -> it maps the input parameter details which is in the body to the model class "User"
		 * @Valid -> it allows to validate the incoming request parameter in accordance with the validation presented in the "User" bean model
		 * */
		@PostMapping("/users")
		public ResponseEntity<Object> createUser (@Valid @RequestBody User newUser) {
		
			User savedUser = userService.saveUser(newUser);
			
			/*1. define the URI location of the new user resource -> /users/{id}:
			 	How? 
				Take the request URI (/users) and append the new user ID (savedUSer.getId())
				a. ServletUriComponentsBuilder
				.fromCurrentRequest() -> returns the current request URI : /users
				b. .path("/{id}") -> append the "/{id}" to the current request URI ("/users")
				c. .buildAndExpand(savedUser.getId()) -> replace the append variable by the new user ID
				d. .toUri() -> convert the result into a URI
			*/
			URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId()).toUri();
			
			/*ResponseEntity -> Allow to return the Response State Code of "201" along with the URI user resource created: /users/{id} 
			*/
			return  ResponseEntity.created(location).build();		
		}
		
		//4. resource deleteUser
			@DeleteMapping("/users/{id}")
			public ResponseEntity<Object> deleteUser(@PathVariable int id) {
				
				User deletedUser = userService.deleteUserByID(id);
				
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(deletedUser.getId()).toUri();
		
				
				return ResponseEntity.noContent().build();
			}
		
	
}

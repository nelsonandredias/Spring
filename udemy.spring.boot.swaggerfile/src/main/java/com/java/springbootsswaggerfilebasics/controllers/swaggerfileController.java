package com.java.springbootsswaggerfilebasics.controllers;


import java.net.URI;
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

import com.java.springbootsswaggerfilebasics.DAOservices.UserService;
import com.java.springbootsswaggerfilebasics.models.User;

/*Swagger file:
  allows you to create a json structure of your APIs so that clients can read and use them. 
 For that:
 	1. add a springfox dependencies that allow us to auto generate swagger files
 		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger2</artifactId>
		    <version>2.6.1</version>
		</dependency>
		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger-ui</artifactId>
		    <version>2.6.1</version>
		</dependency>
	2. create a swagger configuration class with a Bean Docket that uses swagger2 
	to set all paths and apis
	3. the swagger file could be seen in localhost:9090/v2/api-docs or localhost:9090/swagger-ui.html
	
	HOW TO SHARE THE SWAGGER WITH CLIENTS?
	1. open the swagger file in localhost:9090/v2/api-docs and save as json.
 */


@RestController
public class swaggerfileController {

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

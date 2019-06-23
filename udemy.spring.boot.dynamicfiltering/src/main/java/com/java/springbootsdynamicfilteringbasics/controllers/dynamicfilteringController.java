package com.java.springbootsdynamicfilteringbasics.controllers;


import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.java.springbootsdynamicfilteringbasics.DAOservices.UserService;
import com.java.springbootsdynamicfilteringbasics.models.User;

/*Dynamic Filtering for rest services: 
  Basically, just sends specific response details depending of our type of end consumer.
 
	Why should we use dynamic filtering?
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
	
	How to set a dynamic filter to a response property?
	The dynamic filtering should be set where we return the response (controllers)
	
	For that, we should:
	1. In the model class, add to the class the @JsonFilter("customUserFilter1")
	2. Define a local variable of a SimpleBeanPropertyFilter with a custom filter
		that will filter all properties with exception of what we want to retrieve
	3. Create a local variable of a FilterProvider that will set to the User class model
		the custom filter	 
	4. Use the class MappingJacksonValue with the object Bean we want to return
	5. Apply the custom filter "filterForRetrieveAllUsers" to the object response	
 */


@RestController
public class dynamicfilteringController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public MappingJacksonValue retrieveAllUsers(){
		
		List<User> users = userService.findAll();
		
		/*2. Define a local variable of a SimpleBeanPropertyFilter with a custom filter:
		 	 it will filter all properties with exception of what we want to retrieve: user id and name*/
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		
		/*3. Create a local variable of a FilterProvider that will set to the User class model
			 the custom filter "filterForRetrieveAllUsers"*/
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
		
		//4. Use the class MappingJacksonValue with the object Bean we want to return
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		
		//5. Finally, we apply the custom filter "filterForRetrieveAllUsers" to the object response
		mapping.setFilters(filters);
		
		return mapping;	
		
	}
	
	//2. resource retrieveUser
	@GetMapping("/users/{id}")
	public MappingJacksonValue retrieveUser(@PathVariable int id){
			
		User user = userService.findUserByID(id);
		
		//set a default response without any filtering
		
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.setFailOnUnknownId(false);
		
		//4. Use the class MappingJacksonValue with the object Bean we want to return
		MappingJacksonValue mapping = new MappingJacksonValue(user);
				
		//5. Finally, we apply the custom filter "filterForRetrieveAllUsers" to the object response
		mapping.setFilters(filters);
				
		return mapping;	
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

package com.java.springbootsrestbasics.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.springbootsrestbasics.dao.UserDaoService;
import com.java.springbootsrestbasics.exceptions.UserNotFoundException;
import com.java.springbootsrestbasics.models.User;


@RestController
public class usercontroller {

	
	//dependency injection
	@Autowired
	private UserDaoService userDaoService;	
	
	
	//1. resource retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() throws Exception{
		
		List<User> users = userDaoService.findAll();
		
		if(users == null) {
			//set an error message
			throw new Exception("error");
		}
		
		return userDaoService.findAll();
		
	}
	
	//2. resource retrieveUser
	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) throws Exception {
		
		User user = userDaoService.findUserByID(id);
		
		if(user == null) {
			// set an error message 
			throw new UserNotFoundException("id-"+ id);
		}
		

		/*HATEOAS (Hypermedia as the Engine of Application State):
		 *   provides information to navigate the site's REST interfaces dynamically by 
		 *   including hypermedia links with the responses.
		 *   For that:
		 *   1. we need to add to pom.xml the starter <artifactId>spring-boot-starter-data-hateoas</artifactId>
		 *   2. create an object structure resource response -> resource
		 *   3. use controllerlinkbuilder to get the web link associated to a controller method ("retrieveAllUsers()"): /users
		 *   4. associate the web link ("/users") to the object structure resource response via a URI ("all-users")
		*/
		//2. create an object structure resource
		Resource<User> resource = new Resource<User>(user);
		
		
		//3.ControllerLinkBuilder: allows to create links from methods
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		//4. associate the weblink to the object structure resource via a name uri
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	//3. resource createUser
	/*
	 * @RequestBody -> it maps the input parameter details which is in the body to the model class "User"
	 * @Valid -> it allows to validate the incoming request parameter in accordance with the validation presented in the "User" bean model
	 * */
	@PostMapping("/users")
	public ResponseEntity<Object> createUser (@Valid @RequestBody User newUser) {
	
		User savedUser = userDaoService.saveUser(newUser);
		
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
			
			User deletedUser = userDaoService.deleteUserByID(id);
			
			if(deletedUser == null) {
				// set an error message 
				throw new UserNotFoundException("id-"+ id);
			}
			
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(deletedUser.getId()).toUri();
	
			
			return ResponseEntity.noContent().build();
		}
	
	
}

package com.java.springbootsversioningbasics.controllers;


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
import com.java.springbootsversioningbasics.DAOservices.UserService;
import com.java.springbootsversioningbasics.models.UserV1;
import com.java.springbootsversioningbasics.models.UserV2;

/*Versioning for rest services: 
  Evolving a REST API is a difficult and complex task. 
  When REST API reached a point where it’s difficult to expand beyond the original intent, 
  it’s time to consider the next version. 
	
	How to do versioning?
	1. URI versioning: 
		mapping different URIs. I mean, one resource service method for each version
		http://localhost:9090/v1/users	
		http://localhost:9090/v2/users
	2. Request Parameter versioning:
		use different request parameters. I mean, one resource service method for each request parameter version
		http://localhost:9090/users?version=1
		http://localhost:9090/users?version=2
	3. Header versioning:
		use different request headers parameters. I mean, one resource service method for each request header version
		http://localhost:9090/users (in the header set an header parameter version=1)
		http://localhost:9090/users (in the header set an header parameter version=2)
	4. Content Negotiation or Accept Header Versioning (also known as produces) - this is the option mostly used:
		use different header parameters 'produces'. I mean, one produces for each resource service method
		http:localhost:9090/users (in the header set the header Accept parameter to application/version1+json)
		http:localhost:9090/users (in the header set the header Accept parameter to application/version2+json)
 */


@RestController
public class versioningController {

	@Autowired
	private UserService userService;
	
	//1. resource retrieveAllUSers with URI version 1  - Name is just a string
	@GetMapping("/v1/users")
	public MappingJacksonValue retrieveAllUsersV1(){
		
		List<UserV1> userV1s = userService.findAllV1();
		
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userV1s);

		mapping.setFilters(filters);
		
		return mapping;	
		
	}
	
	//1. resource retrieveAllUSers with URI version 2 - Name is a combination of two strings (firstName and lastName)
		@GetMapping("/v2/users")
		public MappingJacksonValue retrieveAllUsersV2(){
			
			List<UserV2> userV2s = userService.findAllV2();
			
			SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
			FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
			MappingJacksonValue mapping = new MappingJacksonValue(userV2s);

			mapping.setFilters(filters);
			
			return mapping;	
			
		}
	
		
	//2. resource retrieveAllUSers with request parameter version 1 - Name is just a string
	@GetMapping(value= "/users/reqparam", params="version=1")
	public MappingJacksonValue retrieveAllUsersReqParamV1(){
					
		List<UserV1> userV1s = userService.findAllV1();
		
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userV1s);

		mapping.setFilters(filters);
		
		return mapping;	
					
	}
	
	
	//2. resource retrieveAllUSers with request parameter version 2  - Name is a combination of two strings (firstName and lastName)
	@GetMapping(value= "/users/reqparam", params="version=2")
	public MappingJacksonValue retrieveAllUsersReqParamV2(){
						
		List<UserV2> userV2s = userService.findAllV2();
			
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
		MappingJacksonValue mapping = new MappingJacksonValue(userV2s);

		mapping.setFilters(filters);
			
		return mapping;	
						
	}
	
	//3. resource retrieveAllUSers with request header version 1 - Name is just a string
	@GetMapping(value= "/users/reqheader", headers="version=1")
	public MappingJacksonValue retrieveAllUsersReqHeaderV1(){
						
		List<UserV1> userV1s = userService.findAllV1();
			
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
		MappingJacksonValue mapping = new MappingJacksonValue(userV1s);

		mapping.setFilters(filters);
			
		return mapping;	
						
	}
	
	//3. resource retrieveAllUSers with request header version 2 - Name is a combination of two strings (firstName and lastName)
	@GetMapping(value= "/users/reqheader", headers="version=2")
	public MappingJacksonValue retrieveAllUsersReqHeaderV2(){
						
		List<UserV2> userV2s = userService.findAllV2();
			
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
		MappingJacksonValue mapping = new MappingJacksonValue(userV2s);

		mapping.setFilters(filters);
			
		return mapping;	
						
	}
	
	//4. resource retrieveAllUSers with header Accept parameter as produces=application/version1+json - Name is just a string
	@GetMapping(value= "/users/produces", produces="application/version1+json")
	public MappingJacksonValue retrieveAllUsersProducesV1(){
						
		List<UserV1> userV1s = userService.findAllV1();
			
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
		MappingJacksonValue mapping = new MappingJacksonValue(userV1s);

		mapping.setFilters(filters);
			
		return mapping;	
						
	}
	
	//4. resource retrieveAllUSers with header Accept parameter as produces=application/version2+json - Name is a combination of two strings (firstName and lastName)
	@GetMapping(value= "/users/produces", produces="application/version2+json")
	public MappingJacksonValue retrieveAllUsersProducesV2(){
						
		List<UserV2> userV2s = userService.findAllV2();
			
		SimpleBeanPropertyFilter filterForRetrieveAllUsers = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
			
		FilterProvider filters = new SimpleFilterProvider().addFilter("customUserFilter1", filterForRetrieveAllUsers);
			
		MappingJacksonValue mapping = new MappingJacksonValue(userV2s);

		mapping.setFilters(filters);
			
		return mapping;	
						
	}
	
	
}

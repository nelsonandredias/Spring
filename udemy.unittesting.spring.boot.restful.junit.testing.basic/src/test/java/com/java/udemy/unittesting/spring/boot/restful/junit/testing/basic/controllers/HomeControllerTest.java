package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)  // we are telling this is a spring 
@WebMvcTest(HomeController.class) //@WebMvcTest allows to test a specific @restController class, in this case the HomeController
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	//test Get method "/home" is called with the expected response "Hello World"
	@Test
	public void callHome() throws Exception {
		
		//call GET request "/home" with the accepted request as application/json
		RequestBuilder request = MockMvcRequestBuilders
									.get("/home")
									.accept(MediaType.APPLICATION_JSON);
		
		//call URI "/home"
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//verify the response is "Hello World"
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}
	
}

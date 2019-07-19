package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;
import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services.ItemBusinessServices;


@RunWith(SpringRunner.class)  // we are telling this is a spring 
@WebMvcTest(ItemController.class) //@WebMvcTest allows to test a specific @restController class, in this case the ItemController
public class ItemControllerTest {

	private static String DUMMY_ITEM_URL = "/dummy-item";
	private static String ITEM_FROM_BUSINESS_SERVICE_URL = "/item-from-business-service";
	private static String RETRIEVE_ALL_ITEMS_URL = "/all-items-from-database";
	
	@Autowired
	private MockMvc mockMvc;
	
	//as ItemController depends on ItemService, we need to mock the businessService layer
	@MockBean
	private ItemBusinessServices itemBusinessServices;
	
	//test Get method "/item"
	@Test
	public void testDummyItem() throws Exception {
		
		//call GET request "/dummy-item" with the accepted request as application/json
		RequestBuilder request = MockMvcRequestBuilders
									.get(DUMMY_ITEM_URL)
									.accept(MediaType.APPLICATION_JSON);
		
		//call URI "/dummy-item"
		MvcResult result = mockMvc
							.perform(request)
							.andExpect(status().is(200)) // we expect from the response the status code 200
							.andExpect(content().json("{id:1,name:'Item 1',price:10,quantity:100}")) 
							.andReturn();
		
		//verify the response is the expected JSON: "{id:1,name:'Item 1',price:10,quantity:100}"
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals("{id:1,name:'Item 1',price:10,quantity:100}", result.getResponse().getContentAsString(), false);
		
	}
	
	
	//test Get method "/item-from-business-service"
	@Test
	public void testItemFromBusinessService() throws Exception {
		
		//as by default a mockBean return null, we need to create and return a new Item from the service
		when(itemBusinessServices.retrieveHardcodedItem()).thenReturn(
				new Item(2, "Item 2", 20, 200));
		
		//call GET request "/item-from-business-service" with the accepted request as application/json
		RequestBuilder request = MockMvcRequestBuilders
									.get(ITEM_FROM_BUSINESS_SERVICE_URL)
									.accept(MediaType.APPLICATION_JSON);
			
		//call URI "/item-from-business-service"
		MvcResult result = mockMvc
							.perform(request)
							.andExpect(status().is(200)) // we expect from the response the status code 200
							.andExpect(content().json("{id:2,name:'Item 2',price:20,quantity:200}")) 
							.andReturn();
			
		//verify the response is the expected JSON: "{id:2,name:'Item 2',price:20,quantity:200}"
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals("{id:2,name:'Item 2',price:20,quantity:200}", result.getResponse().getContentAsString(), false);
			
	}
	
	
	//test Get method "/all-items-from-database"
	@Test
	public void testRetrieveAllItems() throws Exception {
			
		//as by default a mockBean return null, we need to create and return a new Item from the service
		when(itemBusinessServices.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item 2", 20, 200)
							  ,new Item(3, "Item 3", 30, 300)
							  ,new Item(4, "Item 4", 40, 400)
							  )
			);
			
		//call GET request "/item-from-business-service" with the accepted request as application/json
		RequestBuilder request = MockMvcRequestBuilders
										.get(RETRIEVE_ALL_ITEMS_URL)
										.accept(MediaType.APPLICATION_JSON);
				
		//call URI "/all-items-from-database"
		MvcResult result = mockMvc
								.perform(request)
								.andExpect(status().is(200)) // we expect from the response the status code 200
								.andExpect(content().json("[{id:2,name:'Item 2',price:20,quantity:200},{id:3,name:'Item 3',price:30,quantity:300},{id:4,name:'Item 4',price:40,quantity:400}]")) 
								.andReturn();
		
	}
	
}

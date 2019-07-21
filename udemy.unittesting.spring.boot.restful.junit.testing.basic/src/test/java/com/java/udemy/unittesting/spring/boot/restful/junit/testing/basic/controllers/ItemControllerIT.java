package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.controllers;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;
import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.repositories.ItemRepository;

/*Integration Test that talks to real database ("h2memory")
 * The problem here is that if someone makes a change in database, then the coded test will fail.
 * To avoid that, we need to mock that database dependency.
 * */

/*
 With @RunWith and @SpringBootTest we are launching the entire spring boot application when we run tests
 */
@RunWith(SpringRunner.class)  // we are telling that tests are going to be able to get hold of instantiated beans as defined in the Spring context files
//@SpringBootTest annotation: the annotation works by creating the ApplicationContext (@SpringBootApplication) to be used in tests and also launches the h2 memory database.
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)  
public class ItemControllerIT {

	private static String DUMMY_ITEM_URL = "/dummy-item";
	private static String ITEM_FROM_BUSINESS_SERVICE_URL = "/item-from-business-service";
	private static String RETRIEVE_ALL_ITEMS_URL = "/all-items-from-database";
	
	// TestRestTemplate allow us to test HTTP Requests, and also handle the HTTP Responses, presented in the ItemController 
	@Autowired
	private TestRestTemplate testRestTemplate;

	
	//to prevent using real database data, we need to replace the itemRepository by a MockRepository
	@MockBean
	private ItemRepository itemRepository;
	
	
	@Test
	public void contextLoads() throws JSONException {
		
		//mock the return values of itemRepository : basically, what will be returned by database
		when(itemRepository.findAll()).thenReturn(
					Arrays.asList(new Item(10001, "Item 1", 10, 10)
						  ,new Item(10002, "Item 2", 20, 20)
						  ,new Item(10003, "Item 3", 30, 30)
						  ,new Item(10004, "Item 4", 40, 40)
						  ,new Item(10005, "Item 5", 50, 50)
						  ,new Item(10006, "Item 6", 60, 60)
						  ,new Item(10007, "Item 7", 70, 70)
						  )
				);
		
		
		String actualResponse = this.testRestTemplate.getForObject(RETRIEVE_ALL_ITEMS_URL, String.class); //we expect response to be a string
		System.out.println(actualResponse);
		String expectedResponse = "[{\"id\":10001,\"name\":\"Item 1\",\"price\":10,\"quantity\":10,\"value\":100},{\"id\":10002,\"name\":\"Item 2\",\"price\":20,\"quantity\":20,\"value\":400},{\"id\":10003,\"name\":\"Item 3\",\"price\":30,\"quantity\":30,\"value\":900},{\"id\":10004,\"name\":\"Item 4\",\"price\":40,\"quantity\":40,\"value\":1600},{\"id\":10005,\"name\":\"Item 5\",\"price\":50,\"quantity\":50,\"value\":2500},{\"id\":10006,\"name\":\"Item 6\",\"price\":60,\"quantity\":60,\"value\":3600},{\"id\":10007,\"name\":\"Item 7\",\"price\":70,\"quantity\":70,\"value\":4900}]";
		
		//verify that actual response match expected response
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
	}
	
}

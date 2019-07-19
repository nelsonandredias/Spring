package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;
import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.repositories.ItemRepository;

/*
@RunWith(SpringRunner.class) - The Spring Runner which causes all the initialization magic
 with @Mock and @InjectMocks to happen before the tests are run
* */
@RunWith(SpringRunner.class)  // we are telling this is a spring 
public class ItemBusinessServicesTest {

	/*
	  @InjectMocks: creates an instance of the class and injects the mocks that are created
	   with the @Mock annotation into this instance
	 */
	@InjectMocks
	private ItemBusinessServicesImpl itemBusinessServiceImpl;
	
	//create a mock of ItemRepository, that will be used by @InjectMocks
	@Mock
	private ItemRepository itemRepository;
	
	//test business logic of retrieveAllItems()
	@Test
	public void testRetrieveAllItems() {
		
		//make sure repository mocks and returns a List of Items to be used and tested in the service layer
		when(itemRepository.findAll())
		.thenReturn(
				Arrays.asList(new Item(2, "Item 2", 20, 200)
						  ,new Item(3, "Item 3", 30, 300)
						  ,new Item(4, "Item 4", 40, 400)
						  )
				);
		
		//by calling this method we are using the repository mock data 
		List<Item> items = itemBusinessServiceImpl.retrieveAllItems();
		
		
		// test business logic: calculate Item Value: price * quantity
		
			//verify value of first index item: 20*200 = 4000
			assertEquals(items.get(0).getValue(), 4000);
			//verify value of second index item: 30*300 = 9000
			assertEquals(items.get(1).getValue(), 9000);
			//verify value of third index item: 40*400 = 4000
			assertEquals(items.get(2).getValue(), 16000);		
	}
	
	
}

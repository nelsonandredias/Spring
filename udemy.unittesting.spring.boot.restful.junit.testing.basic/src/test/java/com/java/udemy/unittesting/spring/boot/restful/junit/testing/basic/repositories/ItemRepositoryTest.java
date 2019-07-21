package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;

@RunWith(SpringRunner.class)  // we are telling this is a spring 
@DataJpaTest //@DataJpaTest allows to test a specific @repository class, in this case the ItemRepository
/*with @DataJpaTest we are launching H2 in memory database, populate the database based on data.sql
 * 
 * */
public class ItemRepositoryTest {

	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testFindAll() {
		
		List<Item> items = itemRepository.findAll();
		
		//verify that the number of items returned is 7
		assertEquals(7, items.size());
		
	}
	
}

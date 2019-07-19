package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;
import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.repositories.ItemRepository;

@Service
public class ItemBusinessServicesImpl implements ItemBusinessServices{

	private ItemRepository itemRepository;

	@Autowired
	public ItemBusinessServicesImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}


	//retrieve all items
	public List<Item> retrieveAllItems(){
		
		List<Item> items = itemRepository.findAll();
		
		// business logic
		for (Item item : items) {
			
			item.setValue(item.getPrice()* item.getQuantity());
		}
		
		return items;
		
	}
	
	
	public Item retrieveHardcodedItem() {
		
		return new Item(1, "Item 1", 10, 100); 
	}
	
}

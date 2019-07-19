package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services;

import org.springframework.stereotype.Service;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;

@Service
public class ItemBusinessServicesImpl implements ItemBusinessServices{

	public Item retrieveHardcodedItem() {
		
		return new Item(1, "Item 1", 10, 100); 
	}
	
}

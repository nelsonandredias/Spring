package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services;

import java.util.List;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;

public interface ItemBusinessServices {
	
	public Item retrieveHardcodedItem();
	
	public List<Item> retrieveAllItems();
	
	public Item createNewItem(Item newItem);
	
}

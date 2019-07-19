package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;
import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.services.ItemBusinessServices;

@RestController
public class ItemController{
	
	private ItemBusinessServices itemBusinessServices;
	
	
	@Autowired
	public ItemController(ItemBusinessServices itemBusinessServices) {
		super();
		this.itemBusinessServices = itemBusinessServices;
	}

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		
		return new Item(1, "Item 1", 10, 100); 
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		
		return itemBusinessServices.retrieveHardcodedItem();
	}
	
	@GetMapping("all-items-from-database")
	public List<Item> retrieveAllItems(){
		
		return itemBusinessServices.retrieveAllItems();
	}
}

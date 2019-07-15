package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;

@RestController
public class ItemController {

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		
		return new Item(1, "Item 1", 10, 100); 
	}
	
}

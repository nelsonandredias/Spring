package com.java.springbootresth2basics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootresth2basics.entities.Book;
import com.java.springbootresth2basics.services.BookService;


@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){

		List<Book> books = bookService.retrieveAllBooks();
		
		return books;
		
	}
	
}

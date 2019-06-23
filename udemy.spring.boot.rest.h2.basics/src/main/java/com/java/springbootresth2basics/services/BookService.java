package com.java.springbootresth2basics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springbootresth2basics.entities.Book;
import com.java.springbootresth2basics.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> retrieveAllBooks(){
		
		return bookRepository.findAll();
	}
	
}

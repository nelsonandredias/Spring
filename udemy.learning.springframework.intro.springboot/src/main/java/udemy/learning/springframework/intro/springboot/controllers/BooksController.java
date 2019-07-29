package udemy.learning.springframework.intro.springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.learning.springframework.intro.springboot.domains.Book;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<Book> retrieveAllBooks(){
		
		return Arrays.asList(new Book(1,"Book1", "Author1"),
				new Book(2,"Book2", "Author2"),
				new Book(3,"Book3", "Author3"));
				
	}
	
}

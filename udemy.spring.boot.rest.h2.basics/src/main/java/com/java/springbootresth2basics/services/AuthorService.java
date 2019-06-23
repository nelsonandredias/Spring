package com.java.springbootresth2basics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springbootresth2basics.entities.Author;
import com.java.springbootresth2basics.entities.Book;
import com.java.springbootresth2basics.exceptions.EntityNotFoundException;
import com.java.springbootresth2basics.repositories.AuthorRepository;


//holds possible business logic 
@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	//get all authors
	public List<Author> retrieveAllAuthors() throws Exception{
		
		return authorRepository.findAll();
	}
	
	//get a specific author by id
	public Optional<Author> retrieveAuthorByID(int id){
		
		return authorRepository.findById(id);
	}
	
	//save a new author
	public Author saveAuthor(Author newAuthor) {
		
		return authorRepository.save(newAuthor);
	}
	
	public void fullUpdateAuthor(Author fullUpdateAuthor) {
		
		authorRepository.save(fullUpdateAuthor);	
		
	}
	
	//delete a specific author
	public void deleteAuthor (int id) {
		
		authorRepository.deleteById(id);
		
	}


}

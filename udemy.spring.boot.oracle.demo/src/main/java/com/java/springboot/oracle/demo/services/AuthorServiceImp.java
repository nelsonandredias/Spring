package com.java.springboot.oracle.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.oracle.demo.entities.Author;
import com.java.springboot.oracle.demo.repositories.AuthorRepository;

@Service
public class AuthorServiceImp implements AuthorService{
	
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorServiceImp(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public List<Author> getAllAuthor(){
		return authorRepository.findAllById();
	}
	
}

package com.java.springboot.oracle.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.java.springboot.oracle.demo.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

	List<Author> findAllById();
	
}

package com.java.springbootresth2basics.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springbootresth2basics.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


	
}

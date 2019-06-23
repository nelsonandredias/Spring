package com.java.learning.springboot.h2demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.learning.springboot.h2demo.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}

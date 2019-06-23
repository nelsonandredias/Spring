package com.java.learning.springboot.oracledemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.learning.springboot.oracledemo.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}

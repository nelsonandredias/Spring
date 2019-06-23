package com.java.springbootresth2basics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springbootresth2basics.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}

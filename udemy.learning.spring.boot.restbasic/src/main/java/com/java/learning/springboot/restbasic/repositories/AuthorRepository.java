package com.java.learning.springboot.restbasic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.learning.springboot.restbasic.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}

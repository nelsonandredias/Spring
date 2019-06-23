package com.java.springboot.oracle.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.springboot.oracle.demo.entities.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

	Post findBySlug(String slug);

}

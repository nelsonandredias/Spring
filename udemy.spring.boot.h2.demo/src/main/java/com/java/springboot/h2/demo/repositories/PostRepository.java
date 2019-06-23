package com.java.springboot.h2.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.springboot.h2.demo.entities.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

	//find the latest blog post to display on the homepage
	Post findFirstByOrderByPostedOnDesc();

	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);

}

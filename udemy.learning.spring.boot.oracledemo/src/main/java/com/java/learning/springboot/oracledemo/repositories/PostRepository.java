package com.java.learning.springboot.oracledemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.learning.springboot.oracledemo.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	/*custom query - find the latest post to display in homepage*/
	Post findFirstByOrderByPostedOnDesc();
	
	/*custom query - find all posts order by latest*/
	List<Post> findAllByOrderByPostedOnDesc();

	/*custom query - find post based on slug*/
	Post findBySlug(String slug);
	
}

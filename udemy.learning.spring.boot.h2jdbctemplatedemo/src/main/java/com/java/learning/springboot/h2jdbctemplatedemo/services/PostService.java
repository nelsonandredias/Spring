package com.java.learning.springboot.h2jdbctemplatedemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.learning.springboot.h2jdbctemplatedemo.models.Post;
import com.java.learning.springboot.h2jdbctemplatedemo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	
	//return the latest post
	public Post getLatestPost() {
		
		//call custom query
		Post latestPost = postRepository.findFirstByOrderByPostedOnDesc();
		
		return latestPost;
		
	}
	
	//return all posts ordered by date
	public List<Post> getAllPosts(){
		
		//call custom query
		List<Post> allPosts = postRepository.findAllByOrderByPostedOnDesc();
		
		return allPosts;
		
	}

	//return specific post via "read more"
	public Post getSpecificPost(String slug ) {
		
		//call custom query with slug
		Post readPost = postRepository.findBySlug(slug);
		
		return readPost;
	}
	
}

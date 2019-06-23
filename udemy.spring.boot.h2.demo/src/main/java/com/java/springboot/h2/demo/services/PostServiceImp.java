package com.java.springboot.h2.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.h2.demo.entities.Post;
import com.java.springboot.h2.demo.repositories.PostRepository;

@Service
public class PostServiceImp implements PostService{
		
	private PostRepository postRepository;	
	
	@Autowired
	public PostServiceImp(PostRepository postRepository) {
		this.postRepository = postRepository;
	}


	@Override 
	public Post getLatestPost() {
		return postRepository.findFirstByOrderByPostedOnDesc();
	}


	public List<Post> getPostList() {
		return postRepository.findAllByOrderByPostedOnDesc();
	}

	@Override
	public Post getPostBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}
	
	
}

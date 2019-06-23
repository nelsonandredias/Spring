package com.java.learning.springboot.restbasic.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.learning.springboot.restbasic.models.Post;

//service layer that will perform business logic

public interface PostService {

	//retrieve all posts
	public Iterable<Post> getAllPosts();

	//retrieve a specific post by ID
	public Optional<Post> getPostByID(long id);
	
	//create a new Post
	public Post createNewPost(Post post);
	
	//delete an existing post by ID
	public void deletePostbyID(long id);
	
	//update an existing post by ID
	public Post updatePostTitleByID(long id, Post post);
	

}

package com.java.learning.springboot.restbasic.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.learning.springboot.restbasic.exceptions.EntityNotFoundException;
import com.java.learning.springboot.restbasic.models.Post;
import com.java.learning.springboot.restbasic.services.PostService;

//controller layer that will perform routing requests

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	//return all existing posts
	@GetMapping("/")
	public Iterable<Post> getAllPosts(){
		
		return postService.getAllPosts();
		
	}
	
	//return specific post
	@GetMapping("/{id}")
	public Optional<Post> getPostByID(@PathVariable(value="id") long id) {
		
		Optional<Post> post = postService.getPostByID(id);
		
		if (!post.isPresent()) {
			throw new EntityNotFoundException("Post with id " + id + " not found");
		}
		
		return post;
	}
	
	//create a new Post
	@PostMapping("/")
	public Post createNewPost(Post newPost) {
		
		return postService.createNewPost(newPost);
		
	}
	
	//update an existing post title
	@PutMapping("/{id}")
	public Post updatePostTitleByID(@PathVariable(value="id") long id, @RequestBody Post post) {
		
		return postService.updatePostTitleByID(id, post);
		
	}
	
	//delete an existing post
	@DeleteMapping("/{id}")
	public void deletePostByID(@PathVariable(value="id") long id) {
		
		postService.deletePostbyID(id);
		
	}
	
}

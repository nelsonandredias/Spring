package com.java.learning.springboot.h2customqueriesdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.learning.springboot.h2customqueriesdemo.models.Post;
import com.java.learning.springboot.h2customqueriesdemo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	// retrieve all posts
	@RequestMapping("/")
	public Iterable<Post> getAllPosts() {
		
		Iterable<Post> allPosts = postService.getAllPosts();
		
		return allPosts;
	}
	
	
	// retrieve all posts by author
	@RequestMapping("/byAuthor/{authorFirstName}")
	public List<Post> getAllPostsByAuthor(@PathVariable String authorFirstName) {
		
		List<Post> allPostsByAuthor = postService.getAllPostsByAuthor(authorFirstName);
		
		return allPostsByAuthor;
	}

	
	//retrieve all posts by keywords
	@RequestMapping("/byKeyword/{keyword}")
	public List<Post> getAllPostsByKeyword(@PathVariable String keyword){
		
		List<Post> allPostsByKeyword = postService.getAllPostsByKeyword(keyword);
		
		return allPostsByKeyword;
		
	}
	
	
	//retrieve all active posts
	@RequestMapping("/Active")
	public List<Post> getAllPostsActive(){
			
		List<Post> allPostsActive = postService.getAllPostsActive();
			
		return allPostsActive;
			
	}
	
	
	//retrive post by slug
	@RequestMapping("/slug/{slug}")
	public Post findPostBySlug(@PathVariable(value="slug") String slug ) {
		
		Post postBySlug = postService.findBySlug(slug);
		
		return postBySlug;
	}
}

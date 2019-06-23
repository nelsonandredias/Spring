package com.java.learning.springboot.oracledemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.learning.springboot.oracledemo.models.Post;
import com.java.learning.springboot.oracledemo.services.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	// show all posts in "/posts/post/list.html"
	@RequestMapping("/list")
	public String getAllPosts(Model model) {
		
		List<Post> allPosts = postService.getAllPosts();
		
		model.addAttribute("posts", allPosts);
		
		return "/post/list";
	}
	
	//show a specific post via slug "read more"
	@RequestMapping("/view/{slug}")
	public String getSpecificPost(@PathVariable String slug, Model model) {
		
		//get post based on slug
		Post readPost = postService.getSpecificPost(slug);
		
		model.addAttribute("post", readPost);
		
		return "post/view";
		
	}
	
}

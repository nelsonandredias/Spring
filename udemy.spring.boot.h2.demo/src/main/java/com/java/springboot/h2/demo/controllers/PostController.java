package com.java.springboot.h2.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.springboot.h2.demo.services.PostServiceImp;

@Controller
@RequestMapping("/posts")
public class PostController {

private PostServiceImp postServiceImp;
	
	@Autowired
	public PostController(PostServiceImp postServiceImp) {
		this.postServiceImp = postServiceImp;
	}
	
	@RequestMapping("/lists")
	public String listPosts(Model model){
		model.addAttribute("posts", postServiceImp.getPostList());
		return "Post/list.html";
	}
	
	@RequestMapping("/view/{slug}")
	public String view(@PathVariable(value="slug") String slug, Model model){
		model.addAttribute("post", postServiceImp.getPostBySlug(slug));
		return "Post/view.html";
	}
	
}

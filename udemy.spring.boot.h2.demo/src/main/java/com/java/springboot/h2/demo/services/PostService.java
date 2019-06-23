package com.java.springboot.h2.demo.services;


import java.util.List;

import org.springframework.stereotype.Service;
import com.java.springboot.h2.demo.entities.Post;


@Service
public interface PostService{
	
	Post getLatestPost();
	
	Post getPostBySlug(String slug);
}


package com.java.springboot.oracle.demo.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.java.springboot.oracle.demo.entities.Post;


@Service
public interface PostService{
	
	Post getPostBySlug(String slug);
}


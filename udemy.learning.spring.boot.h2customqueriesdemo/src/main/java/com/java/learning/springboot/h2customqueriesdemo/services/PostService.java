package com.java.learning.springboot.h2customqueriesdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.learning.springboot.h2customqueriesdemo.models.Post;
import com.java.learning.springboot.h2customqueriesdemo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	
	//return all posts
	public Iterable<Post> getAllPosts(){
		
		//call generated query
		Iterable<Post> allPosts = postRepository.findAll();
		
		return allPosts;
		
	}

	//return all posts by author first name order by latest
	public List<Post> getAllPostsByAuthor(String authorFirstName) {
		
		//call custom query
		List<Post> allPostsByAuthor = postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(authorFirstName);
		
		return allPostsByAuthor;
		
	}
	
	//return all posts by keyword
	public List<Post> getAllPostsByKeyword(String keyword){
		
		//call custom query
		List<Post> allPostsByKeyword = postRepository.findAllByKeywordsLikeIgnoreCase('%' + keyword + '%');
		
		return allPostsByKeyword;
	}

	//return all active posts
	public List<Post> getAllPostsActive() {
		
		//call custom query
		List<Post> allPostsActive = postRepository.findAllByActiveTrue();
		
		return allPostsActive;
	}

	public Post findBySlug(String slug) {
		
		//call custom query
		Post postBySlug = postRepository.findPostBySlug(slug);
		
		return postBySlug;
	}

	
}

package com.java.learning.springboot.restbasic.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.learning.springboot.restbasic.models.Post;
import com.java.learning.springboot.restbasic.repositories.AuthorRepository;
import com.java.learning.springboot.restbasic.repositories.PostRepository;

//service implementation layer that actually implements Post service business logic

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Iterable<Post> getAllPosts() {

		return postRepository.findAll();
		
	}

	@Override
	public Optional<Post> getPostByID(long id) {
		
		return postRepository.findById(id);
	}

	@Override
	@Transactional
	public Post createNewPost(Post post) {
		
		//save new author
		authorRepository.save(post.getAuthor());
		
		return postRepository.save(post);
		
	}

	@Override
	public void deletePostbyID(long id) {
		
		postRepository.deleteById(id);
		
	}

	@Override
	public Post updatePostTitleByID(long id, Post updatePost) {
		
		Optional<Post> post = postRepository.findById(id);
		if( updatePost.getTitle() != null ) {
			post.ifPresent(n -> n.setTitle(updatePost.getTitle()));
		}
		return postRepository.save(post.get());
		
	}

	
}

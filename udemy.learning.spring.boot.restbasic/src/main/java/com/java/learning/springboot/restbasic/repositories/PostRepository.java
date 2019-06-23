package com.java.learning.springboot.restbasic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.learning.springboot.restbasic.models.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long>{


	/*custom search filter
	 * 
	 * get all posts which title contains the input parameter
	 * */
	List<Post> findByTitleContainingIgnoreCase(@Param("title") String title);
	
}

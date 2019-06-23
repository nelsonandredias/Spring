package com.java.learning.springboot.h2customqueriesdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.java.learning.springboot.h2customqueriesdemo.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

	/* AUTHOR -------------------------------*/
	
	List<Post> findAllByAuthorFirstName(String firstName);
	
	//same query as above but ignoring case sensitive
	List<Post> findAllByAuthorFirstNameIgnoreCase(String firstName);
	
	//all posts of a specific author order by latest
	List<Post> findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String firstName);
	
	//all posts of specific author by full name
	List<Post> findAllByAuthorFirstNameIgnoreCaseAndAuthorLastNameIgnoreCase(String firstName, String lastName);
	
	
	/* KEYWORDS -----------------------------*/
	
	List<Post> findAllByKeywords(String keywoord);
	
	// all posts by keywords where keyword like "%KEYWORD%"
	List<Post> findAllByKeywordsLikeIgnoreCase(String keyword);
	
	
	/* ACTIVE -------------------------------*/
	
	// all posts that are active
	List<Post> findAllByActiveTrue();
	
	
	/* AUTHOR AND KEYWORD -------------------*/
	
	List<Post> findAllByAuthorFirstNameAndKeywords(String first, String keywords);
	
	List<Post> findAllByAuthorFirstNameAndKeywordsOrderByPostedOnDesc(String first, String keywords);
	
	
	/* QUERIES ------------------------------*/
	
	@Query("select p from Post p where p.slug = ?1")
	Post findPostBySlug(String slug);
	
	@Query("select p from Post p where p.slug = :slug")
	Post findPostBySlugNamedParam( @Param("slug") String slug);
	
	@Query( value="SELECT * FROM Post where slug = :slug", nativeQuery = true )
	Post findPostBySlugNative( @Param("slug") String slug);
	
}

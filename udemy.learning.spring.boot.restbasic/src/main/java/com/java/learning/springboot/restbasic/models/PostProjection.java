package com.java.learning.springboot.restbasic.models;

import org.springframework.data.rest.core.config.Projection;

// just display a subset of Post fields
/*
 * it should be called for instance:
 * 	http://localhost:9090/posts/1?projection=postTeaser  
 * */

//@Projection annotation is used when we’re only interested in a subset or a custom view of an entity’s attributes
@Projection(name = "postTeaser", types = {Post.class} )
public interface PostProjection {

	String getTitle();
	
	//String getSlug();
	
	//String getTeaser();
	
}

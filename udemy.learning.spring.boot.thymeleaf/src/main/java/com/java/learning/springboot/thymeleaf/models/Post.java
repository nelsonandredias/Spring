package com.java.learning.springboot.thymeleaf.models;

import java.util.Date;

public class Post {

	private String title;
    private String body;
    private Date posted;
    private String author;
    
	public Post() {
		super();
	}

	public Post(String title, String body, Date posted, String author) {
		super();
		this.title = title;
		this.body = body;
		this.posted = posted;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
    
    
	
}

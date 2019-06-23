package com.java.learning.springboot.h2demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

//@Entity - defines Post class as a persistent JPA model
@Entity
public class Post {
	
	@Id @GeneratedValue
	private Long id;
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@Column(columnDefinition = "TEXT")
	private String teaser;
	
	private String slug;
	
	@CreatedDate
	@Column(columnDefinition = "TIMESTAMP")
	private Date postedOn;

	@ManyToOne // many posts may belong to the same author
	private Author author;
	
	@SuppressWarnings("unused")
	private Post(){
	}
	
	public Post(Long id, String title, String body, String teaser, String slug, Date postedOn) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.teaser = teaser;
		this.slug = slug;
		this.postedOn = postedOn;
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

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}
	
}

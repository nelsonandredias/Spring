package com.java.learning.springboot.restbasic.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	@Column(columnDefinition = "TEXT") //the body is text and has undefined length
	private String body;
	
	@Column(columnDefinition = "TEXT") //the teaser is text and has undefined length
	private String teaser;
	
	private String slug;
	
	@CreatedDate 
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedOn;
	
	@ManyToOne //many posts may belong to the same author
	private Author author;
	
	//construtor necessary for JPA persistence data
	@SuppressWarnings("unused")
	private Post(){
	}
	
	public Post(String title) {
		super();
		this.title = title;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	
}

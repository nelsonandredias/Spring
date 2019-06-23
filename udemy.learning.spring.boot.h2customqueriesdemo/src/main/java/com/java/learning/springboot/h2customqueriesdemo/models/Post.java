package com.java.learning.springboot.h2customqueriesdemo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	
	@ElementCollection //n is mainly for mapping symple types (Strings, etc..) while @OneToMany is used to map entities (Author, Post).
	private List<String> keywords;
	
	//flag property
	private boolean active;
	
	@ManyToOne // many posts may belong to the same author
	private Author author;
	
	@SuppressWarnings("unused")
	private Post(){
	}
	
	public Post(String title){
		this.setTitle(title);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

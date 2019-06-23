package com.java.springboot.oracle.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "POST", schema= "system")
public class Post {

	@Id
	@GeneratedValue
	@Column(name="POST_ID")
	private Long id;
	
	@Column(name="TITLE", columnDefinition = "TEXT")
	private String title;
	
	@Column(name="BODY", columnDefinition = "TEXT")
	private String body;
	
	@Column(name="TEASER", columnDefinition = "TEXT")
	private String teaser;
	
	@Column(name="SLUG", columnDefinition = "TEXT")
	private String slug;
	
	//Author
	//many posts can belong to one author -> it's important to create a @OneToMany in the Author class
	@ManyToOne
	private Author author;
	

	//private no arg constructor is mandatory by JPA
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}
	
}
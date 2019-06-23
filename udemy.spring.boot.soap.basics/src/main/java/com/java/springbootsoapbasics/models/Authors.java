package com.java.springbootsoapbasics.models;

//Authors Bean
public class Authors {
	
	private int id;
	private String author;
	private String book;
	
	
	public Authors(int id, String author, String book) {
		super();
		this.id = id;
		this.author = author;
		this.book = book;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return String.format("Authors [id=%s, author=%s, book=%s]", id, author, book);
	}

	
	
}

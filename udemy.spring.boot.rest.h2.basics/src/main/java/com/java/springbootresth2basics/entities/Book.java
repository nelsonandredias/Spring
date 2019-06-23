package com.java.springbootresth2basics.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Entity - allows to map a Book object instance into a database table
@Entity
@Table(name="Book")
@ApiModel(description="All details about the Book Entity") // allow to set Swagger file properties validation
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="book_id", nullable = false)
	private Integer id;
	
	@NotNull
	@Size(min=2, message="The name of the book should have at least 2 characters.")
	@Column(name="book_name", nullable = false)
	@ApiModelProperty(notes="Name should not be null and must contain at least 2 characters")
	private String name;
	
	//Author
	//many books can belong to one author -> it's important to create a @OneToMany in the Author class
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "author_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore //it will prevent that a list of books would show authors
	private Author author;

	//jpa expects a default constructor
	protected Book() {
	}	

	public Book(Integer id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}

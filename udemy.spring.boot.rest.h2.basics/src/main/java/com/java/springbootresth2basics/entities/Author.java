package com.java.springbootresth2basics.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Entity - allows to map an Author object instance into a database table
@Entity
@Table(name="Author")
@ApiModel(description="All details about the Author Entity") // allow to set Swagger file properties validation
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id", nullable = false)
	private Integer id;
	
	@NotNull
	@Size(min=2, message="Name should have at least 2 characters.")
	@Column(name="author_name", nullable = false)
	@ApiModelProperty(notes="Name should not be null and must contain at least 2 characters")
	private String name;
	
	@NotNull
	@Size(min=2, message="Nationality should have at least 2 characters.")
	@Column(name="author_nationality", nullable = false)
	@ApiModelProperty(notes="Nationality should not be null and must contain at least 2 characters")
	private String nationality;
	
	@NotNull
	@Past
	@Column(name="author_birthdate", nullable = false)
	@ApiModelProperty(notes="Birthdate should be a date in the past")
	private Date birthdate;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
	
	//jpa expects a default constructor
	protected Author() {
	}

	public Author(Integer id, String name, String nationality, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}

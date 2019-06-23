package com.java.springbootsstaticfilteringbasics.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All details about the users")
/*set a @JsonIgnoreProperties(value={"birthdate","id"}), to the model class, with all the class
properties that we want to exclude from the response*/
@JsonIgnoreProperties(value={"birthdate","id"})
public class User {
	
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters.")
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthdate should be in the past")
	//1. set a @JsonIgnore in a User model property to filter out this property in the response
	//@JsonIgnore
	private Date birthdate;
	
	//no argument constructor is necessary to post request
	protected User() {
		super();
	}

	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
	
	
}

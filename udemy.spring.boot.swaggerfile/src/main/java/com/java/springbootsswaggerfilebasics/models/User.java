package com.java.springbootsswaggerfilebasics.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//5. Add the @ApiModel to the User class Model in order to set properties validation
@ApiModel(description="All details about the users")
public class User {
	
	private Integer id;
	
	// @Size -> add a property validation that will be triggered via @Valid annotation in the controller: the name should contain at least 2 characters 
	@Size(min=2, message="Name should have at least 2 characters.")
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	
	//@Past -> add a property validation that will be triggered via @Valid annotation in the controller: the date should always be in the past
	@Past
	@ApiModelProperty(notes="Birthdate should be in the past")
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

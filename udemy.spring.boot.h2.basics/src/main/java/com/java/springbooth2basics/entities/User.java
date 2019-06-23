package com.java.springbooth2basics.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity - allows to map an User object instance into a database table
@Entity
public class User {
	
	
	//@Id - defines that the "User" field "id "is the table primary key
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	
	
	//jpa expects a default constructor
	protected User() {
		super();
	}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
	
	

}

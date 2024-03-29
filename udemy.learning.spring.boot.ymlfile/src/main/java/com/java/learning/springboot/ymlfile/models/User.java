package com.java.learning.springboot.ymlfile.models;

public class User {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return String.format("User [firstName=%s, lastName=%s]", firstName, lastName);
	}
	
	

}

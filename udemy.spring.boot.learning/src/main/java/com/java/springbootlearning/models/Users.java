package com.java.springbootlearning.models;

public class Users {

	private String firstName;
	private String lastName;
	private String emailAddress;
	
	public Users(String firstName, String lastName) {
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
		return "Users: firstName is " + firstName + " and lastName is " + lastName;
	}
	
}

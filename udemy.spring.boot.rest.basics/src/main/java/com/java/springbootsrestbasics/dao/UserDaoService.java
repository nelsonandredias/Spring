
/*
 * DAO is an abbreviation for Data Access Object, so it should encapsulate the logic for retrieving, 
saving and updating data in your data storage (a database, a file-system, whatever). 
 */

package com.java.springbootsrestbasics.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.springbootsrestbasics.models.User;

// this UserDaoService -> will be used to talk with the database

@Component
public class UserDaoService {
	
	//create hardcoded data
	private static List<User> users = new ArrayList<>();
	
	//counter for new usersId
	private static int usersCount = 10;
	
	//initialize hardcoded values
	static {
		users.add(new User(1, "Gabriela Mistral", new Date()));
		users.add(new User(2, "Miguel Ángel Asturias", new Date()));
		users.add(new User(3, "Pablo Neruda", new Date()));
		users.add(new User(4, "Octavio Paz", new Date()));
		users.add(new User(5, "Mario Vargas Llosa", new Date()));
		users.add(new User(6, "José Saramago", new Date()));
		users.add(new User(7, "António Lobo Antunes", new Date()));
		users.add(new User(8, "Leopoldo Marechal", new Date()));
		users.add(new User(9, "Luis Rafael Sánchez", new Date()));
		users.add(new User(10, "José Lezama", new Date()));
		
	}
	
	//1. get all users from database
	public List<User> findAll(){
		
		return users;
		
	}
	
	
	//2. add a new user to database
	public User saveUser(User newUser) {
		
		if (newUser.getId() == null) {
			newUser.setId(++usersCount);
		}
		
		users.add(newUser);
		
		return newUser;
	}
	
	//3. get a specific user from database
	public User findUserByID(int id) {
		
		for (User user:users) {
			 
			if (user.getId() == id) {
				
				return user;
			}
		}
		
		return null;
	}
	
	//4. delete a specific user from database
		public User deleteUserByID(int id) {
			
			Iterator<User> iterator = users.iterator();
			
			while (iterator.hasNext()) {
				User user = iterator.next();
				if (user.getId() == id) {
					iterator.remove();
					return user;
				}
			}
			
			return null;
		}
	
	
}


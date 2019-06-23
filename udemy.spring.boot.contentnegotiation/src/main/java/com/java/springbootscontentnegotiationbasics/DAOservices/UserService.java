package com.java.springbootscontentnegotiationbasics.DAOservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.springbootscontentnegotiationbasics.models.User;


@Component
public class UserService {
	
	//create hardcoded data
		private static List<User> users = new ArrayList<>();
		
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
	

}

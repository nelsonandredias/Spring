package com.java.springbootsversioningbasics.DAOservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.springbootsversioningbasics.models.Name;
import com.java.springbootsversioningbasics.models.UserV1;
import com.java.springbootsversioningbasics.models.UserV2;


@Component
public class UserService {
	
	//create hardcoded data
	private static List<UserV1> userV1s = new ArrayList<>();
	private static List<UserV2> userV2s = new ArrayList<>();
		
	//counter for new usersId
	private static int usersCount = 10;
		
	//initialize hardcoded values for Versioning1
	static {
		userV1s.add(new UserV1(1, "Gabriela Mistral", new Date()));
		userV1s.add(new UserV1(2, "Miguel Ángel Asturias", new Date()));
		userV1s.add(new UserV1(3, "Pablo Neruda", new Date()));
		userV1s.add(new UserV1(4, "Octavio Paz", new Date()));
		userV1s.add(new UserV1(5, "Mario Vargas Llosa", new Date()));
		userV1s.add(new UserV1(6, "José Saramago", new Date()));
		userV1s.add(new UserV1(7, "António Lobo Antunes", new Date()));
		userV1s.add(new UserV1(8, "Leopoldo Marechal", new Date()));
		userV1s.add(new UserV1(9, "Luis Rafael Sánchez", new Date()));
		userV1s.add(new UserV1(10, "José Lezama", new Date()));	
	}
	
	//initialize hardcoded values for Versioning2
		static {
			userV2s.add(new UserV2(1, new Name("Gabriel","Mistral"), new Date()));
			userV2s.add(new UserV2(2, new Name("Miguel","Ángel Asturias"), new Date()));
			userV2s.add(new UserV2(3, new Name("Pablo","Neruda"), new Date()));
			userV2s.add(new UserV2(4, new Name("Octavio","Paz"), new Date()));
			userV2s.add(new UserV2(5, new Name("Mario","Vargas Llosa"), new Date()));
			userV2s.add(new UserV2(6, new Name("José","Saramago"), new Date()));
			userV2s.add(new UserV2(7, new Name("António","Lobo Antunes"), new Date()));
			userV2s.add(new UserV2(8, new Name("Leopoldo","Marechal"), new Date()));
			userV2s.add(new UserV2(9, new Name("Luis","Rafael Sánchez"), new Date()));
			userV2s.add(new UserV2(10, new Name("José","Lezama"), new Date()));	
		}
		
	//1. get all users from database - versioning1
	public List<UserV1> findAllV1(){
			
		return userV1s;
			
	}
	
	//1. get all users from database - versioning2
	public List<UserV2> findAllV2(){
			
		return userV2s;
			
	}

}

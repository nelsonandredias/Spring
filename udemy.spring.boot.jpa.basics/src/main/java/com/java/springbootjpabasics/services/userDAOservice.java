package com.java.springbootjpabasics.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import com.java.springbootjpabasics.entities.User;


//@Repository: it is an annotation that sets the class as a persistent DAO(data access object) layer. Basically, to perform operations against the database
//@Transactional: It defines that each method that will modify data in the database should be inside a transaction. 
@Repository
@Transactional
public class userDAOservice {

	
	//EntityManager: allows to perform operations to the database based on the user entity (save and retrieve users)
	//@PersistenceContext: allows to track any changes of any User instance that will be managed by the Entity Manager. 
	@PersistenceContext
	private EntityManager entityManager;
	
	//save user to the database
	public long saveNewUser(User newUser) {
		
		// it means that the newUser entity will be managed by the EntityManager
		entityManager.persist(newUser);
		
		return newUser.getId();
	}
	
}

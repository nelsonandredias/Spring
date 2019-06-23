package com.java.springbooth2basics.commandrunners;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.java.springbooth2basics.entities.User;
import com.java.springbooth2basics.repositories.UserRepository;

//the component commandrunner is launched when the application context starts
//@Component: it tells that this class will be recognised and managed by spring
@Component
public class userRepositoryCommandRunner implements CommandLineRunner{

	//log of sl4j
	private static final Logger log = LoggerFactory.getLogger(userRepositoryCommandRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// this run method will be used to save User data into database with the help of the JPA save() repository method
		User user1 = new User("André", "User");
		
		User insertedUser = userRepository.save(user1);
		//log created user
		log.info("New user is created: " + insertedUser);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		//log retrieved user with id 1
		log.info("User is id 1: " + userWithIdOne);
		
		List<User> users = userRepository.findAll();
		//log all users
		log.info("All users:" + users);
		
	}

	
	
}

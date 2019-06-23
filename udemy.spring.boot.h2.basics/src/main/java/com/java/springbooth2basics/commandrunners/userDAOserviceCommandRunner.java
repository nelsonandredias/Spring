package com.java.springbooth2basics.commandrunners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.java.springbooth2basics.entities.User;
import com.java.springbooth2basics.services.userDAOservice;

//the component commandrunner is launched when the application context starts
//@Component: it tells that this class will be recognised and managed by spring
@Component
public class userDAOserviceCommandRunner implements CommandLineRunner{

	//log of sl4j
	private static final Logger log = LoggerFactory.getLogger(userDAOserviceCommandRunner.class);
	
	@Autowired
	private userDAOservice userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		// this run method will be used to save User data into database
		User user1 = new User("Nelson", "Admin");
		
		long insertedUser = userDAOService.saveNewUser(user1);
		
		//log user id
		log.info("New user is created: " + user1);
	}

	
	
}

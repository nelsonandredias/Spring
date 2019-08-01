package udemy.learning.springframework.intro.springboot.jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import udemy.learning.springframework.intro.springboot.jpa.domains.Person.Person;
import udemy.learning.springframework.intro.springboot.jpa.repositories.Person.PersonJpaRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository personJpaReposioryImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		LOGGER.info("{}", " All users -> " + personJpaReposioryImpl.findAll().toString());
		LOGGER.info("{}", " User id 10001 -> " + personJpaReposioryImpl.findById(10001).toString());
		LOGGER.info("{}", " Inserting user id 10008 - " + personJpaReposioryImpl.insert(new Person("Telma", "Evora", new Date())));
		LOGGER.info("{}", " updating user id 10008 - " + personJpaReposioryImpl.update(new Person(10003, "Telma", "Portalegre", new Date())));
		
		personJpaReposioryImpl.deleteById(10002);
	}

}

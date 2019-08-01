package udemy.learning.springframework.intro.springboot.jpa.springdata;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import udemy.learning.springframework.intro.springboot.jpa.springdata.domains.Person.Person;
import udemy.learning.springframework.intro.springboot.jpa.springdata.repositories.Person.PersonJpaRepository;
import udemy.learning.springframework.intro.springboot.jpa.springdata.services.Person.PersonJpaService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaService personJpaServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		LOGGER.info("{}", " All users -> " + personJpaServiceImpl.retrieveAllPersons().toString());
		LOGGER.info("{}", " User id 10003 -> " + personJpaServiceImpl.retrievePersonById(10003).toString());
	}

}

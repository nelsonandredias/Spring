package udemy.learning.springframework.intro.springboot.h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import udemy.learning.springframework.intro.springboot.h2.repositories.Person.PersonJDBCDAOImpl;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJDBCDAOImpl personJdbcDaoImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		LOGGER.info("{}", " All users -> " + personJdbcDaoImpl.findAll().toString());
	}

}

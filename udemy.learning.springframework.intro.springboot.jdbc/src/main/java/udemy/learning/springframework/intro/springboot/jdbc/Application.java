package udemy.learning.springframework.intro.springboot.jdbc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import udemy.learning.springframework.intro.springboot.jdbc.domains.Person.Person;
import udemy.learning.springframework.intro.springboot.jdbc.repositories.Person.PersonJDBCDAOImpl;

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
		LOGGER.info("{}", " User id 10001 -> " + personJdbcDaoImpl.findById(10001).toString());
		LOGGER.info("{}", " User name Nelson -> " + personJdbcDaoImpl.findByName("Nelson").toString());
		LOGGER.info("{}", " User location Lisbon -> " + personJdbcDaoImpl.findByLocation("Lisbon").toString());
		LOGGER.info("{}", " User name Bernardo and location Porto -> " + personJdbcDaoImpl.findByNameAndLocation("Bernardo", "Porto"));
		LOGGER.info("{}", " Delete User id 10002 -> Num of Rows Deleted - " + personJdbcDaoImpl.deleteById(10002));
		LOGGER.info("{}", " Delete User name Jose -> Num of Rows Deleted - " + personJdbcDaoImpl.deleteByName("Jose"));
		LOGGER.info("{}", " Delete User location Porto -> Num of Rows Deleted - " + personJdbcDaoImpl.deleteByLocation("Porto"));
		LOGGER.info("{}", " Delete User name Nelson and location Lisbon -> Num of Rows Deleted - " + personJdbcDaoImpl.deleteByNameAndLocation("Nelson", "Lisbon"));
		LOGGER.info("{}", " Inserting user id 10008 - " + personJdbcDaoImpl.insertPerson(new Person(10008, "Telma", "Evora", new Date())));
		LOGGER.info("{}", " updating user id 10008 - " + personJdbcDaoImpl.updatePerson(new Person(10008, "Telma", "Portalegre", new Date())));
	}

}

package udemy.learning.springframework.intro.springboot.jdbc.repositories.Person;

import java.util.List;

import org.springframework.stereotype.Repository;

import udemy.learning.springframework.intro.springboot.jdbc.domains.Person.Person;

@Repository
public interface PersonDAO {

	
	public List<Person> findAll();
	
}

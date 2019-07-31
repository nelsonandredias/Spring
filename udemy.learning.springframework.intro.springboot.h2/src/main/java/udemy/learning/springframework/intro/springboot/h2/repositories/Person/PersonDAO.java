package udemy.learning.springframework.intro.springboot.h2.repositories.Person;

import java.util.List;

import org.springframework.stereotype.Repository;

import udemy.learning.springframework.intro.springboot.h2.domains.Person.Person;

@Repository
public interface PersonDAO {

	
	public List<Person> findAll();
	
}

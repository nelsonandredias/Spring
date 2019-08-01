package udemy.learning.springframework.intro.springboot.jpa.springdata.services.Person;

import java.util.List;

import org.springframework.stereotype.Service;

import udemy.learning.springframework.intro.springboot.jpa.springdata.domains.Person.Person;

@Service
public interface PersonJpaService {
	
	public List<Person> retrieveAllPersons();
	
	public Person retrievePersonById(long id);

}

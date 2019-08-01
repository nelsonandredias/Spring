package udemy.learning.springframework.intro.springboot.jpa.springdata.services.Person;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.springboot.jpa.springdata.domains.Person.Person;
import udemy.learning.springframework.intro.springboot.jpa.springdata.repositories.Person.PersonJpaRepository;

@Component
public class PersonJpaServiceImpl implements PersonJpaService{

	@Autowired
	private PersonJpaRepository personJpaRepository;

	@Override
	public List<Person> retrieveAllPersons() {
		return personJpaRepository.findAll();
	}

	@Override
	public Person retrievePersonById(long id) {
		
		return personJpaRepository.findById(id);
	}
	
	

	
}

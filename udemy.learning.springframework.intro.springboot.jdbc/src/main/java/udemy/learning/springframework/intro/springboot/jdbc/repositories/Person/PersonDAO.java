package udemy.learning.springframework.intro.springboot.jdbc.repositories.Person;

import java.util.List;

import org.springframework.stereotype.Repository;

import udemy.learning.springframework.intro.springboot.jdbc.domains.Person.Person;

@Repository
public interface PersonDAO {

	//GET
	public List<Person> findAll();
	
	public Person findById(long id);
	
	public Person findByName(String name);
	
	public Person findByLocation(String location);
	
	public Person findByNameAndLocation(String name, String location);
	
	//DELETE	
	public int deleteById(long id);
	
	public int deleteByName(String name);
	
	public int deleteByLocation(String location);
	
	public int deleteByNameAndLocation(String name, String location);
	
	public int insertPerson(Person person);
	
	public int updatePerson(Person person);
	
}

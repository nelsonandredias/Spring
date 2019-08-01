package udemy.learning.springframework.intro.springboot.jpa.springdata.repositories.Person;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udemy.learning.springframework.intro.springboot.jpa.springdata.domains.Person.Person;

//Transaction management

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long>{
	
	public List<Person> findAll();
	
	public Person findById(long id);
	
}

package udemy.learning.springframework.intro.springboot.jpa.repositories.Person;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import udemy.learning.springframework.intro.springboot.jpa.domains.Person.Person;

//Transaction management

@Repository
@Transactional
public class PersonJpaRepository {
	
	/*PersistenceContext stores all database operations, and can be used via interface EntityManager.
	 * Thus, EntityManager help us to manage the entities of a specific session*/
	@PersistenceContext
	EntityManager entityManager;
	

	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(long id) {
		return entityManager.find(Person.class, id);	
	};
	
	public Person insert(Person person) {
		//merge allow us to updated or insert new entity rows based on the id. If not exist, it is inserted. Otherwise, it's updated.
		return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		//merge allow us to updated or insert new entity rows
		return entityManager.merge(person);
	}

	public void deleteById(long id) {
		Person person = findById(id);
		entityManager.remove(person);
		
	}
	
}

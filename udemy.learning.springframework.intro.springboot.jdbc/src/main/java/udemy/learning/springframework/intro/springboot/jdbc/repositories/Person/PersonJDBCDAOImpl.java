package udemy.learning.springframework.intro.springboot.jdbc.repositories.Person;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.springboot.jdbc.domains.Person.Person;

@Component
public class PersonJDBCDAOImpl implements PersonDAO {

	//jdbcTemplate allow us to perform queries
	JdbcTemplate jdbcTemplate;


	@Autowired
	public PersonJDBCDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Person> findAll() {
		
		String query = "select * from person";
		
		/*when the query is executed we get a resultSet back.
		 * That resultSet should be mapped to the person domain class via BeanPropertyRowMapper*/
		return jdbcTemplate.query(query, new BeanPropertyRowMapper(Person.class));
	}



	@Override
	public Person findById(long id) {
		
		String query = "select * from person where id=?";
		
		/*queryForObject should be used when we are querying for a specific Object
		 * the ? should be replaced by a list of parameters (Object[]{}). In this case, the array just has the input id
		 */
		return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
	}



	@Override
	public Person findByName(String name) {
		
		String query = "select * from person where name=?";
		
		return jdbcTemplate.queryForObject(query, new Object[]{name}, new BeanPropertyRowMapper<>(Person.class));
		
	}



	@Override
	public Person findByLocation(String location) {
		
		String query = "select * from person where location=?";
		
		return jdbcTemplate.queryForObject(query, new Object[]{location}, new BeanPropertyRowMapper<>(Person.class));
		
	}


	@Override
	public Person findByNameAndLocation(String name, String location) {
		
		String query = "select * from person where name=? and location=?";
		
		return jdbcTemplate.queryForObject(query, new Object[] {name,location}, new BeanPropertyRowMapper<>(Person.class));
	}


	@Override
	public int deleteById(long id) {
		
		String query = "delete from person where id=?";
		
		return jdbcTemplate.update(query, new Object[] {id});
		
	}


	@Override
	public int deleteByName(String name) {
		
		String query = "delete from person where name=?";

		return jdbcTemplate.update(query, new Object[] {name});
	}


	@Override
	public int deleteByLocation(String location) {
		
		String query = "delete from person where location=?";
		
		return jdbcTemplate.update(query, new Object[] {location});
	}


	@Override
	public int deleteByNameAndLocation(String name, String location) {
		
		String query = "delete from person where name=? and location=?";
		
		return jdbcTemplate.update(query, new Object[] {name, location});
	}


	@Override
	public int insertPerson(Person person) {
		
		String query = "insert into person (id, name, location, birth_date) values (?, ?, ?, ?)";
		
		return jdbcTemplate.update(query,
				new Object[] {
						person.getId(),
						person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())
						});
		
	}


	@Override
	public int updatePerson(Person person) {
		
		String query = "update person set name=?, location=?, birth_date=? where id=?";
		
		return jdbcTemplate.update(query,
				new Object[] {
						person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()),
						person.getId()
						});
	}

	
	
}

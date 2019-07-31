package udemy.learning.springframework.intro.springboot.jdbc.repositories.Person;

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
		
		/*
		 * when the query is executed we get a resultSet back.
		 * That resultSet should be mapped to the person domain class via BeanPropertyRowMapper*/
		
		return jdbcTemplate.query(query, new BeanPropertyRowMapper(Person.class));
	}

	
	
}

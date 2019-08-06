package springframework.intro.springboot.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.webapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}

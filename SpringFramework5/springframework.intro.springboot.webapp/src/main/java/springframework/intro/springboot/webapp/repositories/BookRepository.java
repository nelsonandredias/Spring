package springframework.intro.springboot.webapp.repositories;



import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.webapp.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

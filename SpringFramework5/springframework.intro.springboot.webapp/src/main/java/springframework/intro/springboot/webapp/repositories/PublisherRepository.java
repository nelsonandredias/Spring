package springframework.intro.springboot.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.webapp.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}

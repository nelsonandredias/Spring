package springframework.intro.springboot.realproject.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.realproject.models.Visit;



public interface VisitRepository extends CrudRepository<Visit, Long> {

}

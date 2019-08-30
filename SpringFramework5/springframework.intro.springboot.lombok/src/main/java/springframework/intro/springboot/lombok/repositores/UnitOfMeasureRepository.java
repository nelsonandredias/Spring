package springframework.intro.springboot.lombok.repositores;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.lombok.domains.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
	
}

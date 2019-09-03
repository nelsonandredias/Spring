package springframework.intro.springboot.jparelations.recipes.repositores;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.jparelations.recipes.domains.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
	
}

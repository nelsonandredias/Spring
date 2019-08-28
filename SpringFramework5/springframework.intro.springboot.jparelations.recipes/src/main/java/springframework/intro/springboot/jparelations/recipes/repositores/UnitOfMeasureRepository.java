package springframework.intro.springboot.jparelations.recipes.repositores;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.jparelations.recipes.domains.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}

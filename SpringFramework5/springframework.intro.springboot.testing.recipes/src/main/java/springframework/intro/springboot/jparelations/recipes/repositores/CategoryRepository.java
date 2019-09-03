package springframework.intro.springboot.jparelations.recipes.repositores;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.jparelations.recipes.domains.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription(String description);

}

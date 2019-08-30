package springframework.intro.springboot.lombok.repositores;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.lombok.domains.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription(String description);

}

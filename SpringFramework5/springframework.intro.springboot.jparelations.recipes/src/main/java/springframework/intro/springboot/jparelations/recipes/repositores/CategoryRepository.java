package springframework.intro.springboot.jparelations.recipes.repositores;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.jparelations.recipes.domains.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}

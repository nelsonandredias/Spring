package springframework.intro.springboot.jparelations.recipes.repositores;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.jparelations.recipes.domains.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}

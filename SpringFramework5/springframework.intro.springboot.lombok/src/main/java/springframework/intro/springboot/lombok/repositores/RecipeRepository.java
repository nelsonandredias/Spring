package springframework.intro.springboot.lombok.repositores;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.lombok.domains.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}

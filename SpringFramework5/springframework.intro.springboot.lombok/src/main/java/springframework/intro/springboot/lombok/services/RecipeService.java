package springframework.intro.springboot.lombok.services;

import java.util.Set;

import springframework.intro.springboot.lombok.domains.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();

}

package springframework.intro.springboot.jparelations.recipes.services;

import java.util.Set;

import springframework.intro.springboot.jparelations.recipes.domains.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();

}

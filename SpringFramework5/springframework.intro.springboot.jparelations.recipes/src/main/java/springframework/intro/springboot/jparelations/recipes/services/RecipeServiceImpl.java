package springframework.intro.springboot.jparelations.recipes.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import springframework.intro.springboot.jparelations.recipes.domains.Recipe;
import springframework.intro.springboot.jparelations.recipes.repositores.RecipeRepository;


@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}


	@Override
	public Set<Recipe> getRecipes() {
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}

	
}

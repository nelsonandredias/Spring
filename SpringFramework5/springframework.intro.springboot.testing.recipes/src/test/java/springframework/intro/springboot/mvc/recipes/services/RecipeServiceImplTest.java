package springframework.intro.springboot.mvc.recipes.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import springframework.intro.springboot.jparelations.recipes.domains.Recipe;
import springframework.intro.springboot.jparelations.recipes.repositores.RecipeRepository;
import springframework.intro.springboot.jparelations.recipes.services.RecipeServiceImpl;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;
	
	// create a mock of recipe Repository
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception {
		
		// Initialise mocks
		MockitoAnnotations.initMocks(this);
		
		// inject the mock in the service implementation
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void getRecipes() throws Exception {
		
		// create what will be returned
		Recipe recipe = new Recipe();
		HashSet recipeData = new HashSet<>();
		
		recipeData.add(recipe);
		
		// make mockito return something
		when(recipeServiceImpl.getRecipes()).thenReturn(recipeData);
		
		
		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		System.out.println(recipes);
		
		// verify results
		assertEquals(1, recipes.size());
		
		verify(recipeRepository, times(1)).findAll();
	}
	
}

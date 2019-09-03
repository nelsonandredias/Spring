package springframework.intro.springboot.mvc.recipes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


import static org.mockito.Mockito.*;

import springframework.intro.springboot.jparelations.recipes.controllers.IndexController;
import springframework.intro.springboot.jparelations.recipes.services.RecipeService;

public class IndexControllerTest {

	// create Mocks that will be used for testing controller method "getIndexPage"
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
		
		// initialise mocks
		MockitoAnnotations.initMocks(this);
		
		// initialise index controller
		indexController = new IndexController(recipeService);
		
	}
	
	@Test
	public void getIndexPageTest_returnString() throws Exception {
		
		String viewName = indexController.getIndexPage(model);
		
		assertEquals("index", viewName);
		
		// verify service and model are called once
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), any());




	}
	
}

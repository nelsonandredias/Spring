package springframework.intro.springboot.mvc.recipes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;


import static org.mockito.Mockito.*;

import springframework.intro.springboot.jparelations.recipes.controllers.IndexController;
import springframework.intro.springboot.jparelations.recipes.domains.Recipe;
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
	public void testMockMVC() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
		
	}
	
	
	@Test
	public void getIndexPageTest_returnString() throws Exception {
		
		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		
		// when
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		//creation captor instance to verify we capture a Set argument
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		String viewName = indexController.getIndexPage(model);
		
		// then
		assertEquals("index", viewName);

		// verify service and model are called once
		verify(recipeService, times(1)).getRecipes();
		//verify that add method capture a Set argument by using the captor instance above
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());




	}
	
}

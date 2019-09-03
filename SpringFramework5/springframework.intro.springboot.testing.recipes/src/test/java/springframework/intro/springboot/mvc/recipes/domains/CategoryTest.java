package springframework.intro.springboot.mvc.recipes.domains;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import springframework.intro.springboot.jparelations.recipes.domains.Category;

public class CategoryTest {

	Category category;
	
	// get a new category instance for each testing method
	@Before
	public void setUp() {
		category = new Category();
	}
	
	
	@Test
	public void getId() throws Exception {
		Long idValue = 4L;
		
		category.setId(idValue);
		// verify it matches
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception {
	}
	
	@Test
	public void getRecipes() throws Exception {
	}
	
	
}

package springframework.intro.springboot.jparelations.recipes.controllers;

import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springframework.intro.springboot.jparelations.recipes.domains.Category;
import springframework.intro.springboot.jparelations.recipes.domains.UnitOfMeasure;
import springframework.intro.springboot.jparelations.recipes.repositores.CategoryRepository;
import springframework.intro.springboot.jparelations.recipes.repositores.UnitOfMeasureRepository;
import springframework.intro.springboot.jparelations.recipes.services.RecipeService;

@Controller
public class IndexController {


	private final RecipeService recipeService;


	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}



	@GetMapping({"", "/index", "/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
	
	
	
	
}

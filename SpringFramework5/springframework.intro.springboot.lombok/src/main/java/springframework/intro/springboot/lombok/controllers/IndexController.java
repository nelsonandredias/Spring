package springframework.intro.springboot.lombok.controllers;

import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import springframework.intro.springboot.lombok.domains.Category;
import springframework.intro.springboot.lombok.domains.UnitOfMeasure;
import springframework.intro.springboot.lombok.repositores.CategoryRepository;
import springframework.intro.springboot.lombok.repositores.UnitOfMeasureRepository;
import springframework.intro.springboot.lombok.services.RecipeService;

@Slf4j
@Controller
public class IndexController {


	private final RecipeService recipeService;


	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}



	@GetMapping({"", "/index", "/index"})
	public String getIndexPage(Model model) {
		
		//lombok log
		log.debug("Getting index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
	
	
	
	
}

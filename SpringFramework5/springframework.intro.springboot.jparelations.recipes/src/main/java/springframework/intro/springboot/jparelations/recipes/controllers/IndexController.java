package springframework.intro.springboot.jparelations.recipes.controllers;

import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springframework.intro.springboot.jparelations.recipes.domains.Category;
import springframework.intro.springboot.jparelations.recipes.domains.UnitOfMeasure;
import springframework.intro.springboot.jparelations.recipes.repositores.CategoryRepository;
import springframework.intro.springboot.jparelations.recipes.repositores.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	
	@Autowired
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}




	@GetMapping({"", "/index", "/index"})
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Ounce");
		
		System.out.println("Cat ID is: " + categoryOptional.get().getId());
		System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());
		return "index";
	}
	
	
	
	
}

package springframework.intro.springboot.lombok.bootstrap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import springframework.intro.springboot.lombok.domains.Category;
import springframework.intro.springboot.lombok.domains.Difficulty;
import springframework.intro.springboot.lombok.domains.Ingredient;
import springframework.intro.springboot.lombok.domains.Notes;
import springframework.intro.springboot.lombok.domains.Recipe;
import springframework.intro.springboot.lombok.domains.UnitOfMeasure;
import springframework.intro.springboot.lombok.repositores.CategoryRepository;
import springframework.intro.springboot.lombok.repositores.RecipeRepository;
import springframework.intro.springboot.lombok.repositores.UnitOfMeasureRepository;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	
	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		recipeRepository.saveAll(getRecipes());
		log.debug("loading bootstrap data!");
	}
	
	
	private List<Recipe> getRecipes() {
		
		List<Recipe> recipes = new ArrayList<>(2);
		
		//get UOMs
		Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Each");
	
		if (!eachUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("Excepted UOM not Found");
		}
		
		// verify if tablespoon exist
		Optional<UnitOfMeasure> tableSpoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		
		if (!tableSpoonUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("Excepted UOM not Found");
		}
		

		// verify if teaspoon exist
		Optional<UnitOfMeasure> teaSpoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		if (!teaSpoonUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("Excepted UOM not Found");
		}
		
		// verify if dash exist
		Optional<UnitOfMeasure> dashUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Dash");
				
		if (!dashUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("Excepted UOM not Found");
		}
		
		// verify if pint exist
		Optional<UnitOfMeasure> pintUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Pint");
						
		if (!pintUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("Excepted UOM not Found");
		}
		
		// verify if cup exist
		Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUnitOfMeasureOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUnitOfMeasureOptional.get();
        UnitOfMeasure teapoonUom = teaSpoonUnitOfMeasureOptional.get();
        UnitOfMeasure dashUom = dashUnitOfMeasureOptional.get();
        UnitOfMeasure pintUom = pintUnitOfMeasureOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        
        // use setters for JPA bidirectional relationships ( @ManyToMany )
        guacRecipe.setNotes(guacNotes);
        
        // Ingredients
        Ingredient ingredient1Guac = new Ingredient();
        ingredient1Guac.setDescription("ripe avocados");
        ingredient1Guac.setAmount(new BigDecimal(2));
        ingredient1Guac.setUnitOfMeasure(eachUom);
        ingredient1Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient2Guac = new Ingredient();
        ingredient2Guac.setDescription("Kosher salt");
        ingredient2Guac.setAmount(new BigDecimal(".5"));
        ingredient2Guac.setUnitOfMeasure(teapoonUom);
        ingredient2Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient3Guac = new Ingredient();
        ingredient3Guac.setDescription("fresh lime juice or lemon juice");
        ingredient3Guac.setAmount(new BigDecimal(2));
        ingredient3Guac.setUnitOfMeasure(tableSpoonUom);
        ingredient3Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient4Guac = new Ingredient();
        ingredient4Guac.setDescription("minced red onion or thinly sliced green onion");
        ingredient4Guac.setAmount(new BigDecimal(2));
        ingredient4Guac.setUnitOfMeasure(tableSpoonUom);
        ingredient4Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient5Guac = new Ingredient();
        ingredient5Guac.setDescription("serrano chiles, stems and seeds removed, minced");
        ingredient5Guac.setAmount(new BigDecimal(2));
        ingredient5Guac.setUnitOfMeasure(eachUom);
        ingredient5Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient6Guac = new Ingredient();
        ingredient6Guac.setDescription("Cilantro");
        ingredient6Guac.setAmount(new BigDecimal(2));
        ingredient6Guac.setUnitOfMeasure(tableSpoonUom);
        ingredient6Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient7Guac = new Ingredient();
        ingredient7Guac.setDescription("freshly grated black pepper");
        ingredient7Guac.setAmount(new BigDecimal(2));
        ingredient7Guac.setUnitOfMeasure(dashUom);
        ingredient7Guac.setRecipe(guacRecipe);
        
        Ingredient ingredient8Guac = new Ingredient();
        ingredient8Guac.setDescription("ripe tomato, seeds and pulp removed, chopped");
        ingredient8Guac.setAmount(new BigDecimal(".5"));
        ingredient8Guac.setUnitOfMeasure(eachUom);
        ingredient8Guac.setRecipe(guacRecipe);

        // add ingredients to recipe
        guacRecipe.getIngredients().add(ingredient1Guac);
        guacRecipe.getIngredients().add(ingredient2Guac);
        guacRecipe.getIngredients().add(ingredient3Guac);
        guacRecipe.getIngredients().add(ingredient4Guac);
        guacRecipe.getIngredients().add(ingredient5Guac);
        guacRecipe.getIngredients().add(ingredient6Guac);
        guacRecipe.getIngredients().add(ingredient7Guac);
        guacRecipe.getIngredients().add(ingredient8Guac);
        
        
        guacRecipe.getCategory().add(americanCategory);
        guacRecipe.getCategory().add(mexicanCategory);

        //add to return list
        recipes.add(guacRecipe);

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        
        
     // use setters for JPA bidirectional relationships ( @ManyToMany )
        tacosRecipe.setNotes(tacoNotes);


        
     // Ingredients
        Ingredient ingredient1Taco = new Ingredient();
        ingredient1Taco.setDescription("Ancho Chili Powder");
        ingredient1Taco.setAmount(new BigDecimal(2));
        ingredient1Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient1Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient2Taco = new Ingredient();
        ingredient2Taco.setDescription("Dried Oregano");
        ingredient2Taco.setAmount(new BigDecimal(1));
        ingredient2Taco.setUnitOfMeasure(teapoonUom);
        ingredient2Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient3Taco = new Ingredient();
        ingredient3Taco.setDescription("Dried Cumin");
        ingredient3Taco.setAmount(new BigDecimal(1));
        ingredient3Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient3Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient4Taco = new Ingredient();
        ingredient4Taco.setDescription("Sugar");
        ingredient4Taco.setAmount(new BigDecimal(1));
        ingredient4Taco.setUnitOfMeasure(teapoonUom);
        ingredient4Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient5Taco = new Ingredient();
        ingredient5Taco.setDescription("Salt");
        ingredient5Taco.setAmount(new BigDecimal(".5"));
        ingredient5Taco.setUnitOfMeasure(teapoonUom);
        ingredient5Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient6Taco = new Ingredient();
        ingredient6Taco.setDescription("Clove of Garlic, Choppedr");
        ingredient6Taco.setAmount(new BigDecimal(1));
        ingredient6Taco.setUnitOfMeasure(eachUom);
        ingredient6Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient7Taco = new Ingredient();
        ingredient7Taco.setDescription("finely grated orange zestr");
        ingredient7Taco.setAmount(new BigDecimal(1));
        ingredient7Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient7Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient8Taco = new Ingredient();
        ingredient8Taco.setDescription("fresh-squeezed orange juice");
        ingredient8Taco.setAmount(new BigDecimal(3));
        ingredient8Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient8Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient9Taco = new Ingredient();
        ingredient9Taco.setDescription("Olive Oil");
        ingredient9Taco.setAmount(new BigDecimal(2));
        ingredient9Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient9Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient10Taco = new Ingredient();
        ingredient10Taco.setDescription("boneless chicken thighs");
        ingredient10Taco.setAmount(new BigDecimal(4));
        ingredient10Taco.setUnitOfMeasure(tableSpoonUom);
        ingredient10Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient11Taco = new Ingredient();
        ingredient11Taco.setDescription("small corn tortillasr");
        ingredient11Taco.setAmount(new BigDecimal(8));
        ingredient11Taco.setUnitOfMeasure(eachUom);
        ingredient11Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient12Taco = new Ingredient();
        ingredient12Taco.setDescription("packed baby arugula");
        ingredient12Taco.setAmount(new BigDecimal(3));
        ingredient12Taco.setUnitOfMeasure(cupsUom);
        ingredient12Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient13Taco = new Ingredient();
        ingredient13Taco.setDescription("medium ripe avocados, slic");
        ingredient13Taco.setAmount(new BigDecimal(2));
        ingredient13Taco.setUnitOfMeasure(eachUom);
        ingredient13Taco.setRecipe(tacosRecipe);
        
        Ingredient ingredient14Taco = new Ingredient();
        ingredient14Taco.setDescription("radishes, thinly sliced");
        ingredient14Taco.setAmount(new BigDecimal(4));
        ingredient14Taco.setUnitOfMeasure(eachUom);
        ingredient14Taco.setRecipe(tacosRecipe);

        // add ingredients to recipe
        tacosRecipe.getIngredients().add(ingredient1Taco);
        tacosRecipe.getIngredients().add(ingredient2Taco);
        tacosRecipe.getIngredients().add(ingredient3Taco);
        tacosRecipe.getIngredients().add(ingredient4Taco);
        tacosRecipe.getIngredients().add(ingredient5Taco);
        tacosRecipe.getIngredients().add(ingredient6Taco);
        tacosRecipe.getIngredients().add(ingredient7Taco);
        tacosRecipe.getIngredients().add(ingredient8Taco);
        tacosRecipe.getIngredients().add(ingredient9Taco);
        tacosRecipe.getIngredients().add(ingredient10Taco);
        tacosRecipe.getIngredients().add(ingredient11Taco);
        tacosRecipe.getIngredients().add(ingredient12Taco);
        tacosRecipe.getIngredients().add(ingredient13Taco);
        tacosRecipe.getIngredients().add(ingredient14Taco);
        
        tacosRecipe.getCategory().add(americanCategory);
        tacosRecipe.getCategory().add(mexicanCategory);

        recipes.add(tacosRecipe);
        return recipes;
		
	}


	
	
}

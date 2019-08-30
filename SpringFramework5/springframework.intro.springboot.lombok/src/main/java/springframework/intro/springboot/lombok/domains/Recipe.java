package springframework.intro.springboot.lombok.domains;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

//through @Data annotation, Lombok handles all getters and setters for us 
@Data
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	// @Lob allow us to store large binaries
	@Lob
	private String directions;
	
	// @Lob allow us to store large binaries
	@Lob
	private Byte[] image;
	
	@OneToOne( cascade = CascadeType.ALL)
	private Notes notes;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	private Set<Ingredient> ingredients = new HashSet<>();
	
	// set the enumeration data to be persisted in database as a String
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> category = new HashSet<>();

	
	
	public void setNotes(Notes notes) {
		this.notes = notes;
		
		// building association between Notes and Recipes 
		notes.setRecipe(this);
	}
	
	public Recipe addIngredient(Ingredient ingredient) {
		
		// building association between Ingredient and Recipes 
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		return this;
	}

	
	
	
	
}

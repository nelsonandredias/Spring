package springframework.intro.springboot.lombok.domains;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//use @@EqualsAndHashCode to exclude possible circular reference of bidirectional references (@ManyToMany/@ManyToOne/@OneToOne )
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unitOfMeasure;

	
	public Ingredient() {
	}	
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
		super();
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = unitOfMeasure;
	}

	public Ingredient(String description, BigDecimal amount, Recipe recipe, UnitOfMeasure eachUnitOfMeasureOptional) {
		super();
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
		this.unitOfMeasure = eachUnitOfMeasureOptional;
	}

	
	
	
	
}

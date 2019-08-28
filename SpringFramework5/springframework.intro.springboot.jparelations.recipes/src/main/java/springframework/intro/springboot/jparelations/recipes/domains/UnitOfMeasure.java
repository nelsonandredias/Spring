package springframework.intro.springboot.jparelations.recipes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UnitOfMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uom;
	
	@OneToOne
	private Ingredient igredient;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Ingredient getIgredient() {
		return igredient;
	}

	public void setIgredient(Ingredient igredient) {
		this.igredient = igredient;
	}
	
	
	
}

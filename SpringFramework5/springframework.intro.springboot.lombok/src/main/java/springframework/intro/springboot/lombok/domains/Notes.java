package springframework.intro.springboot.lombok.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//use @@EqualsAndHashCode to exclude possible circular reference of bidirectional references (@ManyToMany/@ManyToOne/@OneToOne )
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Notes {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Recipe recipe;
	
	// @Lob allow us to store large strings
	@Lob
	private String recipeNotes;
	
	
}

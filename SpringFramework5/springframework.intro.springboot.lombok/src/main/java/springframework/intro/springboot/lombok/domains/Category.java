package springframework.intro.springboot.lombok.domains;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

// through @Data annotation, Lombok handles all getters and setters for us 
@Data
//use @@EqualsAndHashCode to exclude possible circular reference of bidirectional references (@ManyToMany/@ManyToOne/@OneToOne )
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToMany(mappedBy = "category")
	private Set<Recipe> recipe;
	
}

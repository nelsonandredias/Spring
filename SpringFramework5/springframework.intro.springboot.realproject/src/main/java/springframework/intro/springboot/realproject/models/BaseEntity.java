package springframework.intro.springboot.realproject.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springframework.intro.springboot.realproject.models.Owner.OwnerBuilder;

// Any class declared as superclass with the interface @MappedSuperclass cannot be an entity
/*
 * @MappedSuperclass tells the JPA provider to include the base class persistent properties as 
 	if they were declared by the child class extending the superclass annotated with @MappedSuperclass.
 */
//start - Lombok annotations
@Setter
@Getter
//end - Lombok annotations
@MappedSuperclass
public class BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public boolean isNew() {
		return this.id == null;
	}
	
}

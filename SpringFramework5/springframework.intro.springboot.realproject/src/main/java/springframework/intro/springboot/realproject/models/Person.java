package springframework.intro.springboot.realproject.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springframework.intro.springboot.realproject.models.Owner.OwnerBuilder;

//Any class declared as superclass with the interface @MappedSuperclass cannot be an entity
/*
* @MappedSuperclass tells the JPA provider to include the base class persistent properties as 
	if they were declared by the child class extending the superclass annotated with @MappedSuperclass.
*/
//start - Lombok annotations
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//end - Lombok annotations
@MappedSuperclass
public class Person extends BaseEntity {
	
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
		

}

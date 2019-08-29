package springframework.intro.springboot.realproject.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// Any class declared as superclass with the interface @MappedSuperclass cannot be an entity
/*
 * @MappedSuperclass tells the JPA provider to include the base class persistent properties as 
 	if they were declared by the child class extending the superclass annotated with @MappedSuperclass.
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isNew() {
		return this.id == null;
	}
	
}

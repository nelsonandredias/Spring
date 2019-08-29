package springframework.intro.springboot.realproject.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//Any class declared as superclass with the interface @MappedSuperclass cannot be an entity
/*
* @MappedSuperclass tells the JPA provider to include the base class persistent properties as 
	if they were declared by the child class extending the superclass annotated with @MappedSuperclass.
*/
@MappedSuperclass
public class Person extends BaseEntity {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}

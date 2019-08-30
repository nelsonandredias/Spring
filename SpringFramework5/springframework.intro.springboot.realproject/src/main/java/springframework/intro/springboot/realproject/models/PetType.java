package springframework.intro.springboot.realproject.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springframework.intro.springboot.realproject.models.Owner.OwnerBuilder;

//start - Lombok annotations
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//end - Lombok annotations
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity{

	@Column(name = "name")
	private String name;
	
}

package springframework.intro.springboot.realproject.services;

import java.util.Set;

import springframework.intro.springboot.realproject.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

	public Owner findByLastName(String lastName);
	
}

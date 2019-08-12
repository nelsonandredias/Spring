package springframework.intro.springboot.realproject.services;

import java.util.Set;

import springframework.intro.springboot.realproject.models.Owner;

public interface OwnerService {
	
	public Owner findById(Long id);
	
	public Owner saveNewOwner(Owner newOwner);
	
	public Set<Owner> findAllOwners();

	public Owner findByLastName(String lastName);
	
}

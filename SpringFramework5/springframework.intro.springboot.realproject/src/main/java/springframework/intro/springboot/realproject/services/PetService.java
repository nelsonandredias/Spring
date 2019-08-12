package springframework.intro.springboot.realproject.services;

import java.util.Set;

import springframework.intro.springboot.realproject.models.Pet;



public interface PetService {

	public Pet findById(Long id);
	
	public Pet saveNewPet(Pet newPet);
	
	public Set<Pet> findAllPets();
	
}

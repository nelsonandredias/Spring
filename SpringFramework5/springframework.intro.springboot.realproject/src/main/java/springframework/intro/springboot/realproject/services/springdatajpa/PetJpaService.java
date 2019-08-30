package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.repositories.PetRepository;
import springframework.intro.springboot.realproject.services.PetService;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

	private final PetRepository petRepository;
	
	public PetJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	
	
	@Override
	public Set<Pet> findAll() {
		
		Set<Pet> pets = new HashSet<>();
		
		petRepository.findAll().forEach(pets::add);
		
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		
		Optional<Pet> optionalPet = petRepository.findById(id);
		
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}
		
		return null;
	}

	@Override
	public Pet save(Pet object) {
		
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		
		petRepository.deleteById(id);
		
	}

	
}

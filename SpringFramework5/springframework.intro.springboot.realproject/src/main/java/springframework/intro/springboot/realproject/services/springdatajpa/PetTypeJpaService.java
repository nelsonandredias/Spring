package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.PetType;
import springframework.intro.springboot.realproject.repositories.PetTypeRepository;
import springframework.intro.springboot.realproject.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	
	public PetTypeJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	
	
	@Override
	public Set<PetType> findAll() {
		
		Set<PetType> petTypes = new HashSet<>();
		
		petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		
		Optional<PetType> optionalPetType = petTypeRepository.findById(id);
	
		if(optionalPetType.isPresent()) {
			return optionalPetType.get();
		}
		return null;
	}

	@Override
	public PetType save(PetType object) {
		
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		
		petTypeRepository.deleteById(id);
		
	}

	
}

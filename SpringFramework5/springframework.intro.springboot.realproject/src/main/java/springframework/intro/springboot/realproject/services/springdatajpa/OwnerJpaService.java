package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.repositories.OwnerRepository;
import springframework.intro.springboot.realproject.repositories.PetRepository;
import springframework.intro.springboot.realproject.repositories.PetTypeRepository;
import springframework.intro.springboot.realproject.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService{

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	
	public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	
	@Override
	public Set<Owner> findAll() {
		
		Set<Owner> owners = new HashSet<>();
		
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		
		Optional<Owner> optionalOwner = ownerRepository.findById(id);
		
		if(optionalOwner.isPresent()) {
			return optionalOwner.get();
		}
		return null;
	}

	@Override
	public Owner save(Owner object) {
		
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		
		return ownerRepository.findByLastName(lastName);
	}

	
	
}

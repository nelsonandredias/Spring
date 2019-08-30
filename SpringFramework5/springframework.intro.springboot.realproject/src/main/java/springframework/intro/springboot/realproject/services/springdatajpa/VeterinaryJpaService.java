package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.repositories.SpecialtyRepository;
import springframework.intro.springboot.realproject.repositories.VeterinaryRepository;
import springframework.intro.springboot.realproject.services.VeterinaryService;

@Service
@Profile("springdatajpa")
public class VeterinaryJpaService implements VeterinaryService {

	private final VeterinaryRepository veterinaryRepository;

	public VeterinaryJpaService(VeterinaryRepository veterinaryRepository) {
		super();
		this.veterinaryRepository = veterinaryRepository;
	}
	
	
	
	@Override
	public Set<Veterinary> findAll() {
		
		Set<Veterinary> veterinaries = new HashSet<>();
		
		veterinaryRepository.findAll().forEach(veterinaries::add);
		
		return veterinaries;
	}
	@Override
	public Veterinary findById(Long id) {
		
		Optional<Veterinary> optionalVeterinary = veterinaryRepository.findById(id);
		
		if(optionalVeterinary.isPresent()) {
			return optionalVeterinary.get();
		}
		
		return null;
	}
	@Override
	public Veterinary save(Veterinary object) {
		
		return veterinaryRepository.save(object);
	}
	@Override
	public void delete(Veterinary object) {
		
		veterinaryRepository.delete(object);
		
	}
	@Override
	public void deleteById(Long id) {
		
		veterinaryRepository.deleteById(id);
		
	}
	
	
	
}

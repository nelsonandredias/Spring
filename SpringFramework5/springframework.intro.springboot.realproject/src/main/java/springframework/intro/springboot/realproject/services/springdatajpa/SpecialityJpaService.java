package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Speciality;
import springframework.intro.springboot.realproject.repositories.SpecialtyRepository;
import springframework.intro.springboot.realproject.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService {

	private final SpecialtyRepository specialtyRepository;
	
	public SpecialityJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	
	
	@Override
	public Set<Speciality> findAll() {
		
		Set<Speciality> specialities = new HashSet<>(); 
		
		specialtyRepository.findAll().forEach(specialities::add);
		
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		
		Optional<Speciality> optionalSpeciality = specialtyRepository.findById(id);
		
		if(optionalSpeciality.isPresent()) {
			return optionalSpeciality.get();
		}
		
		return null;
	}

	@Override
	public Speciality save(Speciality object) {
		
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		
		specialtyRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		
		specialtyRepository.deleteById(id);
		
	}

}

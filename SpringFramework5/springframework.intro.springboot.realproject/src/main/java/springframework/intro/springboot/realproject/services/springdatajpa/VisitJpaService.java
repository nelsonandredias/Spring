package springframework.intro.springboot.realproject.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Visit;
import springframework.intro.springboot.realproject.repositories.VisitRepository;
import springframework.intro.springboot.realproject.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService{

	private final VisitRepository visitRepository;
	
	public VisitJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	
	
	@Override
	public Set<Visit> findAll() {
		
		Set<Visit> visits = new HashSet<>();
		
		visitRepository.findAll().forEach(visits::add);
		
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		
		Optional<Visit> optionalVisit = visitRepository.findById(id);
		
		if(optionalVisit.isPresent()) {
			return optionalVisit.get();
		}
		return null;
	}

	@Override
	public Visit save(Visit object) {
		
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		
		visitRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		
		visitRepository.deleteById(id);
		
	}

}

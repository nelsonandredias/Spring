package springframework.intro.springboot.realproject.services.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Visit;
import springframework.intro.springboot.realproject.repositories.VisitRepository;
import springframework.intro.springboot.realproject.services.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	private final VisitRepository visitRepository;

	@Autowired
	public VisitServiceMap(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit save(Visit visit) {
		
		// verify it's a valid visit
		if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}
		
		return super.save(visit);
	}
	
	
	
	
	
}

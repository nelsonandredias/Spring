package springframework.intro.springboot.realproject.services.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Speciality;
import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.services.SpecialityService;
import springframework.intro.springboot.realproject.services.VeterinaryService;

@Service
public class VeterinaryServiceMap extends AbstractMapService<Veterinary, Long> implements VeterinaryService {

	private SpecialityService specialityService;
	
	
	@Autowired
	public VeterinaryServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}
	
	
	@Override
	public Veterinary save(Veterinary object) {
		
		if ( object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(
				speciality -> {
					if (speciality.getId() == null) {
						Speciality savedSpeciality = specialityService.save(speciality);
						speciality.setId(savedSpeciality.getId());
					}
				}
			);
		}
		
		return super.save(object);
	}

	
	
	
}

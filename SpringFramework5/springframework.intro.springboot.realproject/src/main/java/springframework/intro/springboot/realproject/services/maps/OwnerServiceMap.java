package springframework.intro.springboot.realproject.services.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.services.OwnerService;
import springframework.intro.springboot.realproject.services.PetService;
import springframework.intro.springboot.realproject.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService  {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	
	@Autowired
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}


	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner save(Owner object) {
	
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(
					pet -> {
						if ( pet.getPetType() != null) {
							if (pet.getPetType().getId() == null) {
								pet.setPetType(petTypeService.save(pet.getPetType()));
							}
						}else {
							throw new RuntimeException("Pet Type is required");
						}
						
						if (pet.getId() == null) {
							Pet savedPet = petService.save(pet);
							pet.setId(savedPet.getId());
						}					
					}
				);
			}
			return super.save(object);
		} else {
			return null;
		}
		
	}

	

}

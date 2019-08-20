package springframework.intro.springboot.realproject.services.maps;

import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

}

package springframework.intro.springboot.realproject.services.maps;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

}

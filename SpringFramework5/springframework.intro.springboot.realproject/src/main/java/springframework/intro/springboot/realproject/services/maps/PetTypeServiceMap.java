package springframework.intro.springboot.realproject.services.maps;

import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.PetType;
import springframework.intro.springboot.realproject.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}

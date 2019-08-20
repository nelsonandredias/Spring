package springframework.intro.springboot.realproject.services.maps;

import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.services.VeterinaryService;

@Service
public class VeterinaryServiceMap extends AbstractMapService<Veterinary, Long> implements VeterinaryService {

}

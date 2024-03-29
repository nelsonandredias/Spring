package springframework.intro.springboot.realproject.services.maps;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Speciality;
import springframework.intro.springboot.realproject.services.SpecialityService;


@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

}

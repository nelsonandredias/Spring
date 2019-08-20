package springframework.intro.springboot.realproject.services.maps;

import org.springframework.stereotype.Service;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService  {

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

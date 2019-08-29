package springframework.intro.springboot.realproject.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.realproject.models.PetType;



public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}

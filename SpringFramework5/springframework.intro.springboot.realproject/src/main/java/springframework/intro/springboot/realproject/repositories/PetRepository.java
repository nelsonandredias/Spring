package springframework.intro.springboot.realproject.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.realproject.models.Pet;



public interface PetRepository extends CrudRepository<Pet, Long> {

}

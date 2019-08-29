package springframework.intro.springboot.realproject.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.realproject.models.Veterinary;



public interface VeterinaryRepository extends CrudRepository<Veterinary, Long> {

}

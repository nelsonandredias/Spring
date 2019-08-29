package springframework.intro.springboot.realproject.repositories;

import org.springframework.data.repository.CrudRepository;

import springframework.intro.springboot.realproject.models.Speciality;



public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {

}

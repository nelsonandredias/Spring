package springframework.intro.springboot.realproject.repositories;



import org.springframework.data.repository.CrudRepository;
import springframework.intro.springboot.realproject.models.Owner;


public interface OwnerRepository extends CrudRepository<Owner, Long> {

}

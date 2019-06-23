package com.java.springbooth2basics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springbooth2basics.entities.User;

/*Repository: @Repository annotates classes at the persistence layer, which will act as a database repository.
 	It takes the the domain class to manage (User) as well as the id type (Long) of the domain class as type arguments,
 	and acts as a shortcut to manage the entity once the repository has default method already implementated:
 		- save();
 		-findall();
 		-finById();
 		-exists();
 		....
 	Therefore, it prevents repeating code if we have several entities with almost the same service methods with CRUD operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

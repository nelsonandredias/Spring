package springframework.intro.springboot.realproject.services.maps;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.services.PetService;
import springframework.intro.springboot.realproject.services.PetTypeService;

public class OwnerMapServiceTest {
	
	OwnerServiceMap ownerServiceMap;
	
	// properties with constant values
	final Long ownerId = 1L;
    final String lastName = "Smith";
	
	@BeforeEach
	public void setUp() {
		
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
	
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}
	
	@Test
	public void findAll() {
		
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		
		assertEquals(1,  ownerSet.size());
	}
	
	@Test
	public void findById() {
		
		Owner owner = ownerServiceMap.findById(ownerId);
		
		assertEquals(ownerId, owner.getId());
	}
	
	@Test
	public void saveExistingId() {
		
		long id = 2L;
		
		Owner owner2 = Owner.builder().id(id).build();
		
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	public void saveNoId() {
		
		Owner owner3 = Owner.builder().build();
		
		Owner savedOwner = ownerServiceMap.save(owner3);
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
		
	}
	
	
	@Test
	public void delete() {
		
		Owner owner4 = ownerServiceMap.findById(ownerId);
		
		ownerServiceMap.delete(owner4);
		
		assertEquals(0, ownerServiceMap.findAll().size());
		
	}
	
	@Test
	public void deleteById() {
		
		ownerServiceMap.deleteById(ownerId);
		
		assertEquals(0, ownerServiceMap.findAll().size());
		
	}
	
	@Test
	public void findByLastName() {
		
		Owner owner5 = ownerServiceMap.findByLastName(lastName);
		
		assertNotNull(owner5);
		
		assertEquals(ownerId, owner5.getId());
	}
	
	@Test
	public void findByLastName_NotFound() {
		
		Owner owner6 = ownerServiceMap.findByLastName("Silva");
		
		assertNull(owner6);
	}

}

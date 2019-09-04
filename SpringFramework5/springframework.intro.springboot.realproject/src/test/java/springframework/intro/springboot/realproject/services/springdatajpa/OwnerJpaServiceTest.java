package springframework.intro.springboot.realproject.services.springdatajpa;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyLong;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.repositories.OwnerRepository;
import springframework.intro.springboot.realproject.repositories.PetRepository;
import springframework.intro.springboot.realproject.repositories.PetTypeRepository;


@ExtendWith(MockitoExtension.class)
public class OwnerJpaServiceTest {

	public static final String LAST_NAME = "Silva";
	
	// Create mocks for different repos	
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	// Inject repo mocks in the service
	@InjectMocks
	OwnerJpaService ownerJpaService;
	
	Owner returnOwner;
	
	@BeforeEach
	public void setUp() {
		
		//create data for owner repository
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
		
	}
	
	@Test
	public void findByLastName() {

		
		// retrieve data by the repository method "findByLastName"
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner owner1 = ownerJpaService.findByLastName(LAST_NAME);
		
		// verify the last name is the one created
		assertEquals(LAST_NAME, owner1.getLastName());
		
		// verify the repository method is called
		verify(ownerRepository).findByLastName(any());
	}
	
	@Test
	public void findAll() {
		
		Set<Owner> returnOwnersSet = new HashSet<>();
		
		// create set of data
		returnOwnersSet.add(Owner.builder().id(1L).build());
		returnOwnersSet.add(Owner.builder().id(2L).build());
		
		// retrieve data by the repository method "findAll"
		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
		
		Set<Owner> owners = ownerJpaService.findAll();
		
		// verify it returns value
		assertNotNull(owners);
		assertEquals(2, owners.size());
		
	}
	
	@Test
	public void findById() {
		
		// retrieve data by the repository method "findById"
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = ownerJpaService.findById(1L);
		
		assertNotNull(owner);
		
	}
	
	@Test
	public void findById_NotFound() {
		
		// retrieve data by the repository method "findById"
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = ownerJpaService.findById(1L);
		
		assertNull(owner);
		
	}
	
	
	@Test
	public void save() {
		
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		// retrieve data by the repository method "save"
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner savedOwner = ownerJpaService.save(ownerToSave);
		
		assertNotNull(savedOwner);
		
	}
	
	@Test
	public void delete() {
		
		ownerJpaService.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
		
	}
	
	@Test
	public void deleteById() {
		
		ownerJpaService.deleteById(1L);
		
		verify(ownerRepository).deleteById(anyLong());
		
	}
	
}

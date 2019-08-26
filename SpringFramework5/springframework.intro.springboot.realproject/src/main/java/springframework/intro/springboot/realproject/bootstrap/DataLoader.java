package springframework.intro.springboot.realproject.bootstrap;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.models.PetType;
import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.services.OwnerService;
import springframework.intro.springboot.realproject.services.PetTypeService;
import springframework.intro.springboot.realproject.services.VeterinaryService;


/**
 * Initialize and load data once app starts up  
 */
@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VeterinaryService veterinaryService;
	private final PetTypeService petTypeService;

	@Autowired
	public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.veterinaryService = veterinaryService;
		this.petTypeService = petTypeService;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		// PetType
		PetType dog = new PetType();
		dog.setName("Dog");
		
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		
		PetType savedCatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes....");
		
		
		// Owner
		Owner owner1 = new Owner();
		owner1.setFirstName("Nelson");
		owner1.setLastName("Dias");
		owner1.setAddress("Street of Dr Feelgood");
		owner1.setCity("Los Angels");
		owner1.setTelephone("12123412356");
		
		// Owner1 Pets
		Pet owner1Pet = new Pet();
		owner1Pet.setPetType(savedDogPetType);
		owner1Pet.setOwner(owner1);
		owner1Pet.setBirthDate(LocalDate.now());
		owner1Pet.setName("Eros");
		
		owner1.getPets().add(owner1Pet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Romario");
		owner2.setLastName("Lourenço");
		owner2.setAddress("Rua do Metal");
		owner2.setCity("Lisbon");
		owner2.setTelephone("34213412356");
		
		// Owner2 Pets
		Pet owner2Pet = new Pet();
		owner2Pet.setPetType(savedCatPetType);
		owner2Pet.setOwner(owner2);
		owner2Pet.setBirthDate(LocalDate.now());
		owner2Pet.setName("Kitty");
				
		owner2.getPets().add(owner2Pet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners....");
		
		// Veterinary
		Veterinary vet1 = new Veterinary();
		vet1.setFirstName("Sam");
		vet1.setLastName("Smith");
	
		veterinaryService.save(vet1);
		
		Veterinary vet2 = new Veterinary();
		vet2.setFirstName("Paula");
		vet2.setLastName("Francisca");
	
		veterinaryService.save(vet2);
		
		System.out.println("Loaded Veterinaries....");
	}

	

	
	
}

package springframework.intro.springboot.realproject.bootstrap;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.models.Pet;
import springframework.intro.springboot.realproject.models.PetType;
import springframework.intro.springboot.realproject.models.Speciality;
import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.services.OwnerService;
import springframework.intro.springboot.realproject.services.PetService;
import springframework.intro.springboot.realproject.services.PetTypeService;
import springframework.intro.springboot.realproject.services.SpecialityService;
import springframework.intro.springboot.realproject.services.VeterinaryService;


/**
 * Initialize and load data once app starts up  
 */
@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VeterinaryService veterinaryService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		super();
		this.ownerService = ownerService;
		this.veterinaryService = veterinaryService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if (count == 0) {

			loadData();
		}
		
	}


	private void loadData() {
		// PetType
		PetType dog = new PetType();
		dog.setName("Dog");
		
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		
		PetType savedCatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes....");
		
		
		// Specialities
		
		Speciality speciality1 = new Speciality();
		speciality1.setDescription("Radiology");
		
		Speciality savedSpeciality1 = specialityService.save(speciality1);
		
		Speciality speciality2 = new Speciality();
		speciality2.setDescription("Surgery");
		
		Speciality savedSpeciality2 = specialityService.save(speciality2);
		
		Speciality speciality3 = new Speciality();
		speciality3.setDescription("Dentistry");
		
		Speciality savedSpeciality3 = specialityService.save(speciality3);
		
		System.out.println("Loaded Specialities....");	
		
		
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
		vet1.getSpecialities().add(savedSpeciality1);
	
		veterinaryService.save(vet1);
		
		Veterinary vet2 = new Veterinary();
		vet2.setFirstName("Paula");
		vet2.setLastName("Francisca");
		vet2.getSpecialities().add(savedSpeciality2);
		vet2.getSpecialities().add(savedSpeciality3);
	
		veterinaryService.save(vet2);
		
		System.out.println("Loaded Veterinaries....");
	}


	
}

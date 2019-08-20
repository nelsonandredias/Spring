package springframework.intro.springboot.realproject.bootstrap;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.models.Veterinary;
import springframework.intro.springboot.realproject.services.OwnerService;
import springframework.intro.springboot.realproject.services.VeterinaryService;


/**
 * Initialize and load data once app starts up  
 */
@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VeterinaryService veterinaryService;

	@Autowired
	public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService) {
		
		this.ownerService = ownerService;
		this.veterinaryService = veterinaryService;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		// Owner
		Owner owner1 = new Owner();
		owner1.setFirstName("Nelson");
		owner1.setLastName("Dias");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Ana");
		owner2.setLastName("Lourenço");
		
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

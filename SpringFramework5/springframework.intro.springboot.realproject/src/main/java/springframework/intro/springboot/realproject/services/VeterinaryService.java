package springframework.intro.springboot.realproject.services;

import java.util.Set;

import springframework.intro.springboot.realproject.models.Veterinary;


public interface VeterinaryService {

	public Veterinary findById(Long id);
	
	public Veterinary saveNewVeterinary(Veterinary newVeterinary);
	
	public Set<Veterinary> findAllVeterinaries();
	
}

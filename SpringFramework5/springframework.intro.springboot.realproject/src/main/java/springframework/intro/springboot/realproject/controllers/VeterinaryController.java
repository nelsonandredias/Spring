package springframework.intro.springboot.realproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springframework.intro.springboot.realproject.services.VeterinaryService;

@Controller
public class VeterinaryController {

	
	private final VeterinaryService veterinaryService;
	
	
	@Autowired
	public VeterinaryController(VeterinaryService veterinaryService) {
		super();
		this.veterinaryService = veterinaryService;
	}



	@GetMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
	public String listVets(Model model) {
		
		model.addAttribute("vets", veterinaryService.findAll());
		
		return "vets/veterinary";
	}
	
}

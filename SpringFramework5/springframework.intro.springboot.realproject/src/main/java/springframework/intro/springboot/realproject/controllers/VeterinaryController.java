package springframework.intro.springboot.realproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VeterinaryController {

	@GetMapping("/vets")
	public String listVets(Model model) {
		
		return "vets/veterinary";
	}
	
}

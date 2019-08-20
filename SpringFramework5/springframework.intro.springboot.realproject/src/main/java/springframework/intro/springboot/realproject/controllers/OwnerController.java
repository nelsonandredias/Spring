package springframework.intro.springboot.realproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springframework.intro.springboot.realproject.services.OwnerService;

@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	

	@GetMapping("/owners")
	public String listOwners(Model model) {
		
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/owner";
	}
	
}

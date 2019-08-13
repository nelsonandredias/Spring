package springframework.intro.springboot.realproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

	@GetMapping("/owners")
	public String listOwners(Model model) {
		
		return "owners/owner";
	}
	
}

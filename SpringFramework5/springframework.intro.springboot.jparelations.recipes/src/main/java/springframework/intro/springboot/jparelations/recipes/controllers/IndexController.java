package springframework.intro.springboot.jparelations.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	@GetMapping({"", "/index", "/index"})
	public String getIndexPage() {
		
		return "index";
	}
	
}
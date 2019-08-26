package springframework.intro.springboot.realproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/oups")
	public String errorpage() {
		
		return "notImplemented";
	}
	
}

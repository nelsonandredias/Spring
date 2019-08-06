package udemy.learning.springframework.intro.springboot.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homepage() {
		return "homepage";
	}
	
}

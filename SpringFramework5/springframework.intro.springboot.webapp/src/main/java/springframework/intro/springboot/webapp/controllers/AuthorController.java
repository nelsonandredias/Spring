package springframework.intro.springboot.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springframework.intro.springboot.webapp.models.Author;
import springframework.intro.springboot.webapp.services.AuthorService;

@Controller
public class AuthorController {

	private AuthorService authorService;
	
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}



	@GetMapping("/authors")
	public String retrieveAllAuthors(Model model) {
		
		model.addAttribute("authors", authorService.getAllAuthors());
		
		return "authors";
	}
	
}

package springframework.intro.springboot.jokes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springframework.intro.springboot.jokes.app.services.JokeService;

@Controller
public class JokeController {

	private JokeService jokeService;

	@Autowired
	public JokeController(JokeService jokeService) {
		super();
		this.jokeService = jokeService;
	}
	
	@GetMapping("/")
	public String showJoke(Model model) {
		
		model.addAttribute("joke", jokeService.getJoke());
		return "chucknorris"; 
	}
	
}

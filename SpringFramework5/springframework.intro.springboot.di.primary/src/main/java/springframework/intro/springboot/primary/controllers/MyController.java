package springframework.intro.springboot.primary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.primary.services.GreetingService;
import springframework.intro.springboot.primary.services.PrimaryGreetingService;

@Controller
public class MyController {

	
	private GreetingService greetingService;
	
	@Autowired
	public MyController( GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}




	public String hello() {
		return greetingService.sayGreeting() ;
	}
	
}

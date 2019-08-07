package springframework.intro.springboot.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.di.services.GreetingService;

@Controller
public class ConstructorInjectedController {

	/*inject interface*/
	private GreetingService greetingService;

	/* constructor dependency injection */
	@Autowired
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}

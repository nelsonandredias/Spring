package springframework.intro.springboot.componentscan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.services.GreetingService;



@Controller
public class ConstructorInjectedController {

	/*inject interface*/
	private GreetingService greetingService;

	/* constructor dependency injection */
	@Autowired
	public ConstructorInjectedController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}

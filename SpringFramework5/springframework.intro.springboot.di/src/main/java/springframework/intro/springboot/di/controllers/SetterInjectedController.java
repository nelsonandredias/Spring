package springframework.intro.springboot.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.di.services.GreetingService;

@Controller
public class SetterInjectedController {

	//inject the interface
	private GreetingService greetingService;
	
	/*setter Dependency Injection*/
	@Autowired
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}

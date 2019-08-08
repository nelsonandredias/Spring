package springframework.intro.springboot.primary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.primary.services.GreetingService;

@Controller
public class SetterInjectedController {

	//inject the interface
	private GreetingService greetingService;
	
	/*setter Dependency Injection*/
	@Autowired
	public void setGreetingService(@Qualifier("setterGreetingServiceImpl") GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}

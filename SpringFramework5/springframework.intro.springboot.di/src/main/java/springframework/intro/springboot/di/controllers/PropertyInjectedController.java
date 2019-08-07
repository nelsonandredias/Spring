package springframework.intro.springboot.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.di.services.GreetingServiceImpl;

@Controller
public class PropertyInjectedController {

	@Autowired
	public GreetingServiceImpl greetingService;
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
	
}

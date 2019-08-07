package springframework.intro.springboot.qualifiers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springframework.intro.springboot.qualifiers.services.GreetingService;

@Controller
public class PropertyInjectedController {

	@Autowired
	public GreetingService greetingServiceImpl;
	
	public String sayHello() {
		return greetingServiceImpl.sayGreeting();
	}
	
	
}

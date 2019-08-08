package springframework.intro.springboot.profiles.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService{

	@Override
	public String sayGreeting() {
		return "Hello World - I was injected by constructor";
	}

	
	
}

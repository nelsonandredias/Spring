package springframework.intro.springboot.qualifiers.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService{

	@Override
	public String sayGreeting() {
		return "Hello World - I was injected by constructor";
	}

	
	
}

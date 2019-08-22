package springframework.intro.springboot.yaml.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	public static final String HELLO_WORLD = "Hello World!!!!";

	@Override
	public String sayGreeting() {
		return HELLO_WORLD;
	}

	
	
}

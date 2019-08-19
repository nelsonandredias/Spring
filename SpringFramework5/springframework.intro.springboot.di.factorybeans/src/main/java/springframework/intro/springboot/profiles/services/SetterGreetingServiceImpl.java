package springframework.intro.springboot.profiles.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - I was injected by the setter";
	}

}

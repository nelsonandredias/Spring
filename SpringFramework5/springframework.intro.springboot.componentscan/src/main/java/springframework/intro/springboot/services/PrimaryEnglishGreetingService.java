package springframework.intro.springboot.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("en")
@Primary
public class PrimaryEnglishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		
		return "Hello World - from primary english service";
	}

}

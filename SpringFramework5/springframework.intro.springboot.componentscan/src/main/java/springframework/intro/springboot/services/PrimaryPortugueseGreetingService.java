package springframework.intro.springboot.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"pt", "default"})
public class PrimaryPortugueseGreetingService implements GreetingService{

	@Override
	public String sayGreeting() {
		return "Serviço de saudação primário";
	}

}

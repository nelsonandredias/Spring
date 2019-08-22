package springframework.intro.springboot.yaml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.yaml.repositories.GreetingRepository;


public class PrimaryEnglishGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;
	
	@Autowired
	public PrimaryEnglishGreetingService(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}
	
	
	@Override
	public String sayGreeting() {
		
		return greetingRepository.getEnglishGreeting();
	
	}

	

}

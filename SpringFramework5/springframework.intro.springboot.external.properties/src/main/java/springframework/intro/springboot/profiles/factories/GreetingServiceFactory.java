package springframework.intro.springboot.profiles.factories;

import org.springframework.beans.factory.annotation.Autowired;

import springframework.intro.springboot.profiles.repositories.GreetingRepository;
import springframework.intro.springboot.profiles.services.GreetingService;
import springframework.intro.springboot.profiles.services.PrimaryEnglishGreetingService;
import springframework.intro.springboot.profiles.services.PrimaryPortugueseGreetingService;
import springframework.intro.springboot.profiles.services.PrimarySpanishGreetingService;

public class GreetingServiceFactory {

	private GreetingRepository greetingRepository;

	@Autowired
	public GreetingServiceFactory(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}
	
	/*
	 * select the service based on the language
	*/
	public GreetingService createGreetingService(String lang) {
		
		switch (lang) {
		case "en":
			return new PrimaryEnglishGreetingService(greetingRepository);
		case "es":
			return new PrimarySpanishGreetingService(greetingRepository);
		case "pt":
			return new PrimaryPortugueseGreetingService(greetingRepository);
		default:
			return new PrimaryEnglishGreetingService(greetingRepository);
		}
		
	}
}

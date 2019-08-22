package springframework.intro.springboot.yaml.factories;

import org.springframework.beans.factory.annotation.Autowired;

import springframework.intro.springboot.yaml.repositories.GreetingRepository;
import springframework.intro.springboot.yaml.services.GreetingService;
import springframework.intro.springboot.yaml.services.PrimaryEnglishGreetingService;
import springframework.intro.springboot.yaml.services.PrimaryPortugueseGreetingService;
import springframework.intro.springboot.yaml.services.PrimarySpanishGreetingService;

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

package springframework.intro.springboot.profiles.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {

	@Override
	public String getEnglishGreeting() {
		
		return "Hello - Primary Greeting service";
	
	}

	@Override
	public String getSpanishGreeting() {
		
		return "Servicio de Saludo Primario";
		
	}

	@Override
	public String getPortugueseGreeting() {
		
		return "Serviço de saudação primário";
		
	}

}

package springframework.intro.springboot.di.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import springframework.intro.springboot.primary.controllers.ConstructorInjectedController;
import springframework.intro.springboot.primary.services.GreetingServiceImpl;

public class ConstructorInjectedControllerTest {

	private ConstructorInjectedController constructorInjectedController;
	
	@Before
	public void setUp() {
		this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
	}
	
	@Test
	public void testGreeting() {

		//verify the output string in the controller is the same retrieving by the service implementation 
		assertEquals(GreetingServiceImpl.HELLO_WORLD, constructorInjectedController.sayHello());
	}
	
}

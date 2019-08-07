package springframework.intro.springboot.di.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import springframework.intro.springboot.qualifiers.controllers.SetterInjectedController;
import springframework.intro.springboot.qualifiers.services.GreetingServiceImpl;

public class SetterInjectedControllerTest {

	private SetterInjectedController setterInjectedController;
	
	@Before
	public void setUp() {
		this.setterInjectedController = new SetterInjectedController();
		this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
	}
	
	@Test
	public void testGreeting() {

		//verify the output string in the controller is the same retrieving by the service implementation 
		assertEquals(GreetingServiceImpl.HELLO_WORLD, setterInjectedController.sayHello());
	}
	
}

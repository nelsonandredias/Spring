package springframework.intro.springboot.di.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import springframework.intro.springboot.qualifiers.controllers.PropertyInjectedController;
import springframework.intro.springboot.qualifiers.services.GreetingServiceImpl;

public class PropertyInjectedControllerTest {

	private PropertyInjectedController propertyInjectedController;
	
	@Before
	public void setUp() {
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
	}
	
	@Test
	public void testGreeting() {

		//verify the output string in the controller is the same retrieving by the service implementation 
		assertEquals(GreetingServiceImpl.HELLO_WORLD, propertyInjectedController.sayHello());
	}
	
}

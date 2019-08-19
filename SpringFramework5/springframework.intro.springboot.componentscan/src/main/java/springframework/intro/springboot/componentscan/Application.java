package springframework.intro.springboot.componentscan;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import springframework.intro.springboot.componentscan.controllers.ConstructorInjectedController;
import springframework.intro.springboot.componentscan.controllers.MyController;
import springframework.intro.springboot.componentscan.controllers.PropertyInjectedController;
import springframework.intro.springboot.componentscan.controllers.SetterInjectedController;

@SpringBootApplication
@ComponentScan(basePackages= {"springframework.intro.springboot.services", "springframework.intro.springboot.componentscan"})
public class Application {

	public static void main(String[] args) {
		
		final Logger LOGGER = LoggerFactory.getLogger(Application.class);
		
		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		
		//get Bean "MyController" by type
		MyController myController = appContext.getBean(MyController.class);
		//get Bean "PropertyInjectedController" by Bean type
		PropertyInjectedController propertyInjectedController = appContext.getBean(PropertyInjectedController.class);
		//get Bean "SetterInjectedController" by Bean Id and Bean type 
		SetterInjectedController setterInjectedController = appContext.getBean("setterInjectedController", SetterInjectedController.class);
		//get Bean "ConstructorInjectedController" by Bean type
		ConstructorInjectedController constructorInjectedController = appContext.getBean(ConstructorInjectedController.class);
		
		LOGGER.info("{} Bean is -> " + myController.hello());
		LOGGER.info("{} PropertyInjectedController Bean is -> " + propertyInjectedController.sayHello());
		LOGGER.info("{} SetterInjectedController Bean is -> " + setterInjectedController.sayHello());
		LOGGER.info("{} ConstructorInjectedController Bean is -> " + constructorInjectedController.sayHello());
	}

}

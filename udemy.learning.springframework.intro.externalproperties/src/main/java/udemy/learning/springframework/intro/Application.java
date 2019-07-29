package udemy.learning.springframework.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.intro.externalproperties.ExternalProperties;
import udemy.learning.springframework.intro.repository.PersonDAO;



@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class Application {

	//we will log the application
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Application.class);
		
		//Array with Beans loaded
		LOGGER.info("Beans loaded -> {}", (Object)context.getBeanDefinitionNames());
		
		ExternalProperties extProp = context.getBean(ExternalProperties.class);
		
		LOGGER.info("external property -> {}", extProp.returnServiceURL());

	}

}

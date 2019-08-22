package springframework.intro.springboot.yaml;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import springframework.intro.springboot.yaml.beans.FakeDataSource;
import springframework.intro.springboot.yaml.beans.FakeJMSBroker;
import springframework.intro.springboot.yaml.controllers.MyController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		final Logger LOGGER = LoggerFactory.getLogger(Application.class);
		
		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		
		//get Bean "MyController" by type
		MyController myController = appContext.getBean(MyController.class);
		
		LOGGER.info("{} Bean is -> " + myController.hello());
		
		//get Bean "FakeDataSource" by type
		FakeDataSource fakeDataSource = appContext.getBean(FakeDataSource.class);
	
		LOGGER.info("{} Bean properties are -> " + fakeDataSource.toString());
		
		//get Bean "FakeJMSSource" by type
		FakeJMSBroker fakeJmsSource = appContext.getBean(FakeJMSBroker.class);
			
		LOGGER.info("{} Bean properties are -> " + fakeJmsSource.toString());
		
	}

}

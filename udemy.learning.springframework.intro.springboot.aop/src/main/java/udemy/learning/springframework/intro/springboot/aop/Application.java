package udemy.learning.springframework.intro.springboot.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import udemy.learning.springframework.intro.springboot.aop.businesses.Business1;
import udemy.learning.springframework.intro.springboot.aop.businesses.Business2;

/*whatever is defined in CommandLine will be invoked when the application context is launched*/

@SpringBootApplication
public class Application implements CommandLineRunner{

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Business1 business1;
	
	@Autowired
	private Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//method declared in CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		
		LOGGER.info("{}", "business1 " + business1.calculateSomething());
		LOGGER.info("{}", "business2 " + business2.calculateSomething());
	}

}

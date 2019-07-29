package udemy.learning.springframework.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.intro.business.BubbleSortAlgorithm;
import udemy.learning.springframework.intro.business.QuickSortAlgorithm;
import udemy.learning.springframework.intro.cdi.SomeCDIBusiness;

@SpringBootApplication
public class Application {

	//we will log the application
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		//acess bean after applicationcontext completion
		SomeCDIBusiness cdiBusiness = context.getBean(SomeCDIBusiness.class);
		
		LOGGER.info("{}", "cdiBusiness " + cdiBusiness);

	}

}

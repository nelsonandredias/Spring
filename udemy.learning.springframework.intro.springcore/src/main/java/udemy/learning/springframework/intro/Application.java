package udemy.learning.springframework.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.intro.business.BubbleSortAlgorithm;
import udemy.learning.springframework.intro.business.QuickSortAlgorithm;
import udemy.learning.springframework.intro.cdi.SomeCDIBusiness;

@Configuration
@ComponentScan
public class Application {

	//we will log the application
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		//creating application context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
				
		//acess bean after applicationcontext completion
		BinarySearchImpl binarySearchImpl = context.getBean(BinarySearchImpl.class);
		

		LOGGER.info("{}", "binarySearchImpl " + binarySearchImpl);

		int result = binarySearchImpl.binarySearch(new int[] {2,5,6,8,9},5);
		
		LOGGER.info("{}", "result " + result);
		
		
		//kill applicationContext
		context.close();
	}

}

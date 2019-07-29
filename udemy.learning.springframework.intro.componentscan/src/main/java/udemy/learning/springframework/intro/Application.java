package udemy.learning.springframework.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.package2.PersonDAO;


@SpringBootApplication
@ComponentScan({"udemy.learning.springframework.intro", "udemy.learning.springframework.package2"})
public class Application {

	//we will log the application
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		//acess bean after applicationcontext completion
		
		BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);
		
		LOGGER.info("{}", binarySearch);
		
		PersonDAO personInstance1 = context.getBean(PersonDAO.class);
		PersonDAO personInstance2 = context.getBean(PersonDAO.class);
//		
//		LOGGER.info("{}", "personInstance1 " + personInstance1);
//		LOGGER.info("{}", "personInstance2 " + personInstance2);
//		
//		LOGGER.info("{}", "JdbcConnection1 from personInstance1 " + personInstance1.getJdbcConnection());
//		LOGGER.info("{}", "JdbcConnection2 from personInstance1 " + personInstance1.getJdbcConnection());
//		LOGGER.info("{}", "JdbcConnection1 from personInstance2 " + personInstance2.getJdbcConnection());
		

	}

}

package udemy.learning.springframework.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.package2.PersonDAO;
import udemy.learning.springframework.xml.XmlPersonDAO;



public class Application {

	//we will log the application
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Array with Beans loaded
		LOGGER.info("Beans loaded -> {}", (Object)context.getBeanDefinitionNames());
		
		//acess bean after applicationcontext completion
		XmlPersonDAO personInstance1 = context.getBean(XmlPersonDAO.class);
		XmlPersonDAO personInstance2 = context.getBean(XmlPersonDAO.class);
		
		LOGGER.info("{}", "personInstance1 " + personInstance1);
		LOGGER.info("{}", "personInstance2 " + personInstance2);
		
		LOGGER.info("{}", "JdbcConnection1 from personInstance1 " + personInstance1.getXmlJdbcConnection());
		LOGGER.info("{}", "JdbcConnection2 from personInstance1 " + personInstance1.getXmlJdbcConnection());
		LOGGER.info("{}", "JdbcConnection1 from personInstance2 " + personInstance2.getXmlJdbcConnection());
		

	}

}

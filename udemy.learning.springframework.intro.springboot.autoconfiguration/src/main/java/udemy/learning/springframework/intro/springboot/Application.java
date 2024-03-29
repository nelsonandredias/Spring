package udemy.learning.springframework.intro.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		
		for (String bean : appContext.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
	}

}

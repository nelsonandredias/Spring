package udemy.learning.springframework.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import udemy.learning.springframework.intro.business.BinarySearchImpl;
import udemy.learning.springframework.intro.business.BubbleSortAlgorithm;
import udemy.learning.springframework.intro.business.QuickSortAlgorithm;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		//acess bean after applicationcontext completion
		BinarySearchImpl binarySearchInstance1 = context.getBean(BinarySearchImpl.class);
		
		BinarySearchImpl binarySearchInstance2 = context.getBean(BinarySearchImpl.class);
		
		System.out.println(binarySearchInstance1);
		System.out.println(binarySearchInstance2);
		
		System.out.println(binarySearchInstance1==binarySearchInstance2);
	}

}

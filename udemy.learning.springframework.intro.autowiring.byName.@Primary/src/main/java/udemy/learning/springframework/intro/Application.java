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
		BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] {12, 4, 6}, 3);
		
		System.out.println(result);
	}

}

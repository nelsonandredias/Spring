package udemy.learning.springframework.intro.business;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {

	private SortAlgorithm sortAlgorithm;
	

	//constructor-based dependency injection
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}


	public int binarySearch(int[] numbers, int numberToSearchFor) {
		
		//implement array sorting
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		
		System.out.println(sortAlgorithm);
		
		//search number in array
		return 3;
	}
	
	
	//when BinarySearchImpl bean is created and initialized with dependencies, the postConstruct will be called
	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct called");
	}
	
	//right after BinarySearchImpl bean is used and the applicationContext is closing, the preDestroy will be called
	@PreDestroy
	public void preDestroy() {
		System.out.println("predestroy called");
	}

	
}

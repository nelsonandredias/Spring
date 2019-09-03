package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
	
}

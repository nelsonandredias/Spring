package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
public class BinarySearchImpl {

	//inject bean dependency
	/*As there are two implementations (BubbleSortAlgorithm and QuickSortAlgorithm) of the interface SortAlgorith,
	 * we can autowire by @Qualifier.
	 * Otherwise, we can choose which implementation we want by using the @Primary or by Name
	 * By default, the @Qualifier is picked over @Primary and Bean id
	 */

	private SortAlgorithm sortAlgorithm;
	

	//constructor-based dependency injection
	public BinarySearchImpl(@Qualifier("bubble") 
								SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	
	//setter-based dependency injection
	/*public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}*/


	public int binarySearch(int[] numbers, int numberToSearchFor) {
		
		//implement array sorting
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		
		System.out.println(sortAlgorithm);
		
		//search number in array
		
		return 3;
	}
	
}

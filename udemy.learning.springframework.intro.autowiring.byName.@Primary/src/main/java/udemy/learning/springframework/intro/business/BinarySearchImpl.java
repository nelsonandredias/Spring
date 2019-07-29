package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
public class BinarySearchImpl {

	//inject bean dependency
	/*As there are two implementations (BubbleSortAlgorithm and QuickSortAlgorithm) of the interface SortAlgorith,
	 * we can autowire by Bean id.
	 * Otherwise, we can choose which implementation we want by using the @Primary annotation the corresponding component
	 * By default, the @Primary is picked instead of Bean id
	 */
	@Autowired
	private SortAlgorithm quickSortAlgorithm;
	

	//constructor-based dependency injection
	public BinarySearchImpl(SortAlgorithm quickSortAlgorithm) {
		super();
		this.quickSortAlgorithm = quickSortAlgorithm;
	}
	
	//setter-based dependency injection
	/*public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}*/


	public int binarySearch(int[] numbers, int numberToSearchFor) {
		
		//implement array sorting
		int[] sortedNumbers = quickSortAlgorithm.sort(numbers);
		
		System.out.println(quickSortAlgorithm);
		
		//search number in array
		
		return 3;
	}
	
}

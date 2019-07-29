package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] numbers) {
		
		//logic for bubble sort algorithm
		
		return numbers;
	}

}

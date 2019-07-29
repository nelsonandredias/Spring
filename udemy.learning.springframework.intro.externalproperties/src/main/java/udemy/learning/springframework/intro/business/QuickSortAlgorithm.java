package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Service
@Qualifier("quick")
@Primary
public class QuickSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] numbers) {
		
		//logic for quick sort algorithm
		
		return numbers;
	}

}

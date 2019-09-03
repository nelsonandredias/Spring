package udemy.learning.springframework.intro.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.data.SortAlgorithm;

@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuickSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] numbers) {
		
		//logic for quick sort algorithm
		
		return numbers;
	}

}

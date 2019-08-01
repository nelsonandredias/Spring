package udemy.learning.mockito.business;


import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void testHamcrestCapabilities_List() {
		
		List<Integer> scores = Arrays.asList(99, 100, 101, 105, 123, 104, 163, 195, 136);
		
		//List test examples
			
			//verify score has 4 items
			assertThat(scores, hasSize(9));
			//verify score contains 105, 123 and 163
			assertThat(scores, hasItems(105, 123, 163));
			
			//every item in the list greater than 90
			assertThat(scores, everyItem(greaterThan(90)));
			
			//every item in the list lower than 200
			assertThat(scores, everyItem(lessThan(200)));		
		
	}
	
	@Test
	public void testHamcrestCapabilities_String() {
		
		//String test examples
		
			//verify string is empty
			assertThat("", isEmptyString());
			
			//verify something is null
			assertThat(null, isEmptyOrNullString());
			
	}
	
	@Test
	public void testHamcrestCapabilities_Arrays() {
		
		Integer[] marks = {1, 2, 3, 4};
		
		//Array test examples
		
			//verify array size is 4
			assertThat(marks, arrayWithSize(4));
		
			//verify array contains all marks
			assertThat(marks, arrayContainingInAnyOrder(1,3,4,2));
	}
	
	
	
}

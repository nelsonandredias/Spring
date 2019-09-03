package udemy.learning.springframework.intro.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import udemy.learning.springframework.intro.Application;


@RunWith(SpringRunner.class) //launch the loaded configuration
@ContextConfiguration(classes=Application.class) //Load application context
public class BinarySearchTest {

	//get BinarySearchImpl bean from the application context
	@Autowired
	BinarySearchImpl binarySearchImpl;
	
	@Test
	public void testBasic() {
		
		int actualResult = binarySearchImpl.binarySearch(new int[] {}, 5);
		
		//check if result is correct
		assertEquals(3, actualResult);
	}

}

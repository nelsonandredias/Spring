package udemy.learning.mockito.business;

import static org.hamcrest.Matchers.array;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;


/*a Spy gets all logic from the class:
 * a spy by default retains all logic from arrayList*/

public class SpyTest {

	
	@Test
	public void testSpy_SizeMethod() {
		
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		
		arrayListSpy.add("First Index");
		
		//Then
		assertEquals(1, arrayListSpy.size());
		
		arrayListSpy.remove("First Index");
		
		assertEquals(0, arrayListSpy.size());
		
	}
	
}

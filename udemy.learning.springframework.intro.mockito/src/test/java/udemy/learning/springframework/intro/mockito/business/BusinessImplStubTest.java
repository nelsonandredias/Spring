package udemy.learning.springframework.intro.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import udemy.learning.springframework.intro.business.BusinessImpl;
import udemy.learning.springframework.intro.mockito.data.DataServiceStub;

/*
 * Ideally, we should avoid using Stubs because if we want to test different scenarios, we must
 * create a "DataServiceStub" class for each testing scenario.
 * A better solution would be using mocks.
 * */
public class BusinessImplStubTest {

	
	@Test
	public void testFindGreatestFromAllData() {
		
		//inject data stub for testing
		BusinessImpl businessImpl = new BusinessImpl(new DataServiceStub());
		
		int result = businessImpl.findGreatestFromAllData();
		
		assertEquals(24, result);
	}
	
}

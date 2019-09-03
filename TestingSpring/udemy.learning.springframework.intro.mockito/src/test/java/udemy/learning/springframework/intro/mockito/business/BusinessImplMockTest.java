package udemy.learning.springframework.intro.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import udemy.learning.springframework.intro.business.BusinessImpl;
import udemy.learning.springframework.intro.data.DataService;
import udemy.learning.springframework.intro.mockito.data.DataServiceStub;


public class BusinessImplMockTest {

	
	@Test
	public void testFindGreatestFromAllData() {
		
		//creating a mock for DataService interface
		DataService dataServiceMock = mock(DataService.class);
		//when mock is called, the DataService mock will return:
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,6,16});
		
		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);	
		int result = businessImpl.findGreatestFromAllData();		
		assertEquals(24, result);
	}
	
	@Test
	public void testFindGreatestFromAllData_ForOneValue() {
		
		//creating a mock for DataService interface
		DataService dataServiceMock = mock(DataService.class);
		//when mock is called, the DataService mock will return:
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		
		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);	
		int result = businessImpl.findGreatestFromAllData();		
		assertEquals(15, result);
	}
	
}

package udemy.learning.springframework.intro.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import udemy.learning.springframework.intro.business.BusinessImpl;
import udemy.learning.springframework.intro.data.DataService;

//when we use Mock annotation, we should use the annotation @RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class BusinessImplMockAnnotationTest {

	//creating a mock for DataService interface
	@Mock
	DataService dataServiceMock;
	
	/*as DataService is a dependency of BusinessImpl, we should use @Inject annotation to inject
	  mock dependencies in the BusinessImpl component
	*/
	@InjectMocks
	BusinessImpl businessImpl;
	
	@Test
	public void testFindGreatestFromAllData() {
		
		//when mock is called, the DataService mock will return:
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,6,16});
		
		assertEquals(24, businessImpl.findGreatestFromAllData());
	}
	
	@Test
	public void testFindGreatestFromAllData_ForOneValue() {
		
		//when mock is called, the DataService mock will return:
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		
		assertEquals(15, businessImpl.findGreatestFromAllData());
	}
	
	@Test
	public void testFindGreatestFromAllData_NoValues() {
		
		//when mock is called, the DataService mock will return:
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		
		assertEquals(Integer.MIN_VALUE, businessImpl.findGreatestFromAllData());
	}
	
}

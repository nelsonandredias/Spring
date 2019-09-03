package udemy.learning.springframework.intro.cdi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import udemy.learning.springframework.intro.Application;

@RunWith(MockitoJUnitRunner.class)
public class SomeCDIBusinessTest {

	//Create Mock for SomeCdiDAO
	@Mock
	SomeCdiDAO someCdiDao;
	
	//Inject Mock in SomeCdiBusiness
	@InjectMocks
	SomeCDIBusiness someCDIBusiness;
	
	@Test
	public void testBasicCDI() {
		
		// when getData is called, we will create hard coded data
		when(someCdiDao.getData()).thenReturn(new int[] {1,63,177,1354});
		
		int actualResult = someCDIBusiness.findGreatest();	
		assertEquals(1354, actualResult);		
	}

	@Test
	public void testBasicCDI_NullValue() {
		
		// when getData is called, we will create hard coded data
		when(someCdiDao.getData()).thenReturn(new int[] {});
		
		int actualResult = someCDIBusiness.findGreatest();	
		assertEquals(Integer.MIN_VALUE, actualResult);		
	}
	
	@Test
	public void testBasicCDI_EqualValues() {
		
		// when getData is called, we will create hard coded data
		when(someCdiDao.getData()).thenReturn(new int[] {5,5,5});
		
		int actualResult = someCDIBusiness.findGreatest();	
		assertEquals(5, actualResult);		
	}
	
}

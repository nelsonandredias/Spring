package udemy.learning.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void testList_SizeMethod() {
		
		List listMock = mock(List.class);
		 
		when(listMock.size()).thenReturn(2);
		
		//Then
		assertEquals(2, listMock.size());
		
	}
	
	
	@Test
	public void testList_ReturnMultipleValues() {
		
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		
	}

	
	@Test
	public void testList_GetMethod() {
		
		List listMock = mock(List.class);
		
		when(listMock.get(0)).thenReturn("first value");
		
		assertEquals("first value", listMock.get(0));
		assertEquals(null, listMock.get(1));
		
	}
	
	@Test
	public void testList_GetMethodGeneric() {
		
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt())).thenReturn("generic value");
		
		assertEquals("generic value", listMock.get(0));
		assertEquals("generic value", listMock.get(1));
		
	}
	
	@Test
	public void testList_GetMethodGenericUsingBDDMock() {
		
		//1. given
			
			List<String> listMock = mock(List.class);
			given(listMock.get(anyInt())).willReturn("generic value");
		
		//2. when 
		
			String firstElement = listMock.get(0);
			String secondElement = listMock.get(1);
			
		//3. then
		
			assertThat(firstElement, is("generic value"));
			assertThat(secondElement, is("generic value"));
		
	}
	
	//validate error exception
	@Test(expected= RuntimeException.class)
	public void testList_ThrowException() {
		
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something is wrong"));
		
		listMock.get(0);
		
	}
	
	//validate error exception
	@Test(expected= RuntimeException.class)
	public void testList_MixingUp() {
			
		List listMock = mock(List.class);
			
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something is wrong"));
			
		listMock.get(0);
			
	}
}

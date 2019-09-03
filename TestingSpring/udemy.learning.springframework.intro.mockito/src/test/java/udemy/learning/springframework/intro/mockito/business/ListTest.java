package udemy.learning.springframework.intro.mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


public class ListTest {

	@Test
	public void testListSize() {
		
		List listMock = mock(List.class);		
		when(listMock.size()).thenReturn(10);
		assertEquals(10, listMock.size());
		
	}

	@Test
	public void testList_GetSpecificParameter() {
		
		List listMock = mock(List.class);		
		when(listMock.get(0)).thenReturn("First Result");
		
		assertEquals("First Result", listMock.get(0));
		assertEquals(null, listMock.get(1));
		
	}
	
	@Test
	public void testList_GetGenericParameter() {
		
		List listMock = mock(List.class);		
		when(listMock.get(Mockito.anyInt())).thenReturn("Generic Result");
		
		assertEquals("Generic Result", listMock.get(0));
		assertEquals("Generic Result", listMock.get(1));
		assertEquals("Generic Result", listMock.get(2));
		assertEquals("Generic Result", listMock.get(3));
	
	}
	
}

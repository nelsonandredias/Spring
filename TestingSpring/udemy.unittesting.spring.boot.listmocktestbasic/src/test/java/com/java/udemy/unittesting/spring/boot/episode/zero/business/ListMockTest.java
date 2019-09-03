package com.java.udemy.unittesting.spring.boot.episode.zero.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ListMockTest {

	//mocking a list interface
	List mock = Mockito.mock(List.class);
	
	@Test
	public void listMockTest_size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
		
	}
	
	//Returning multiple values from the same method
	@Test
	public void listMockTest_return_different_sizes() {
				
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
		
	}
	
	//Returning a string back and validate it
	@Test
	public void listMockTest_return_With_parameters_valid() {
		
		when(mock.get(0)).thenReturn("ReturnedParameter");
		
		// validate if the first index of the list returns the expected parameter
		assertEquals("ReturnedParameter", mock.get(0));
		
		assertEquals(null, mock.get(2));
		
	}
	
	//Returning a string back and validate it
	@Test
	public void listMockTest_return_With_generic_parameter() {
			
		// any index of the list will returns the generic parameter
		when(mock.get(anyInt())).thenReturn("GenericParameter");
		assertEquals("GenericParameter", mock.get(0));
		assertEquals("GenericParameter", mock.get(2));
			
	}
	
}

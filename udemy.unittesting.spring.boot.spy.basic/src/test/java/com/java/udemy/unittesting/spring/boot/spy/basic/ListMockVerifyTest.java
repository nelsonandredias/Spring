package com.java.udemy.unittesting.spring.boot.spy.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.verification.AtLeast;

/*
 * useful to verify for instance when we have a method that saves some value in database.
 * we want to confirm that the method of saving data is called
 * */


public class ListMockVerifyTest {

	//mocking a list interface
	List<String> mock = Mockito.mock(List.class);
	
	@Test
	public void verification_basic() {
		
		//SUT (calling the method for testing purpose in the verify)
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//verify that the get method is called on the mock list
		verify(mock).get(0);
		
		verify(mock, times(2)).get(anyInt());
		
		//verify the get method of the mock list is called at least one time
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		
		//verify the get method of the mock list is called at most twice
		verify(mock, atMost(2)).get(anyInt());
		
		//verify the get method with the index 2 is never called
		verify(mock, never()).get(2);
		
	}
	
	
	@Test
	public void argumentCapturing() {
		
		//SUT (calling the method for testing purpose in the verify)
		mock.add("Hello World");
	
		
		//creation captor instance to verify we capture a string argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		//verify that add method capture a string argument by using the captor instance above
		verify(mock).add(captor.capture());
		
		//verify the argument capture is the same passed in the method add
		assertEquals("Hello World", captor.getValue());
	}
	
	
	@Test
	public void multipleArgumentCapturing() {
		
		//SUT (calling methods for testing purpose in the verify)
		mock.add("Hello World");
		mock.add("Goodbye World");

		
		//creation captor instance to verify we capture a string argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		/*verify that add method the two times its called, 
		  it capture a string argument by using the captor instance above*/
		verify(mock, times(2)).add(captor.capture());
		
		//verify all argument captured are the same passed to add method
		List<String> allValues = captor.getAllValues();
		assertEquals("Hello World", allValues.get(0));
		assertEquals("Goodbye World", allValues.get(1));
		
	}
	
	
	/*The difference between mock and spy is that spy, retains behavior of the original class
	 */
	
	@Test
	public void mocking_NotRetaining() {
		
		ArrayList arrayListMock = Mockito.mock(ArrayList.class);
		
		System.out.println(arrayListMock.get(0)); // it will return null
		System.out.println(arrayListMock.size()); // it will return 0
		
		//As this arrayList is a mock class, if we add 2 values to the list the arrayList size will stay as 0
		// A mock does not retain behavior (code) of the original class
		arrayListMock.add("Nelson");
		arrayListMock.add("Dias");
		System.out.println(arrayListMock.size()); // it will return 0 as well
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); // it will return 5 as well
		
	}
	
	
	@Test
	public void spying_Retaining() {
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		
		arrayListSpy.add("Starting ArrayList");
		System.out.println(arrayListSpy.get(0)); // it will return "Starting ArrayList"
		System.out.println(arrayListSpy.size()); // it will return 1
		
		//As this arrayList is a spy class, if we add 2 values to the list the arrayList size will be updated to 3
		// A spy does retain behavior (code) of the original class
		arrayListSpy.add("Nelson");
		arrayListSpy.add("Dias");
		System.out.println(arrayListSpy.size()); // it will return 3 as well
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); // it will return 5 as well
		
		arrayListSpy.add("Ending ArrayList");
		System.out.println(arrayListSpy.size()); // it will return 5 as well
		
		
		//verify the add method is called with the argument "Dias"
		verify(arrayListSpy).add("Dias");
	}
	
	
}

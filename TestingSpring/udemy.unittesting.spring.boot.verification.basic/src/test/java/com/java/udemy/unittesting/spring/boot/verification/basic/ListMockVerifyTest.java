package com.java.udemy.unittesting.spring.boot.verification.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;



import org.junit.jupiter.api.Test;
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
	
}

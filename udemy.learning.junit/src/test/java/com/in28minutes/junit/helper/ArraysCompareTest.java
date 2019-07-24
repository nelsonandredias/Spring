package com.in28minutes.junit.helper;


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
	
		int[] numbers = {12,3,4,1};	
		int[] expectedValues= {1,3,4,12};		
		//sort the values of number array by lowest to highest
		Arrays.sort(numbers);
		
		assertArrayEquals(expectedValues, numbers);
	}
	
	// test null array exception
	@Test(expected=NullPointerException.class)
	public void testArraySort_NullArray() {
	
		int[] numbers = null;		

		//sort the values of number array by lowest to highest
		Arrays.sort(numbers);

	}

	//test sort performance: less than 1second
	@Test(timeout=1000)
	public void testSort_Performance() {
		
		int array[] = {12,23,4};
		
		for(int i=1;i<10000000;i++) {
			
			array[0]=i;
			Arrays.sort(array);
		}
		
	}
	
}

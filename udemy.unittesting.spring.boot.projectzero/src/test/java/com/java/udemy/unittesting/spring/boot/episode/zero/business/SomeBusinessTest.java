package com.java.udemy.unittesting.spring.boot.episode.zero.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSum_basicOK() {
		
		BusinessImpl businessImpl = new BusinessImpl();
		
		int actualResult = businessImpl.calculateSum(new int[] {1,2,3,4});
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSum_basicNotOK() {
			
		BusinessImpl businessImpl = new BusinessImpl();
			
		int actualResult = businessImpl.calculateSum(new int[] {1,2,3,4});
		int expectedResult = 1;
		assertNotEquals(expectedResult, actualResult);
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSum_basic_emptyOK() {
				
		BusinessImpl businessImpl = new BusinessImpl();
				
		int actualResult = businessImpl.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSum_basic_oneValueOK() {
						
		BusinessImpl businessImpl = new BusinessImpl();
						
		int actualResult = businessImpl.calculateSum(new int[] {100});
		int expectedResult = 100;
		assertEquals(expectedResult, actualResult);
	}

}

package com.java.udemy.unittesting.spring.boot.verification.basic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.udemy.unittesting.spring.boot.episode.verification.basic.BusinessImpl;
import com.java.udemy.unittesting.spring.boot.episode.zero.services.SomeDataService;

/*
 @RunWith(MockitoJUnitRunner.class) - The JUnit Runner which causes all the initialization magic
  with @Mock and @InjectMocks to happen before the tests are run
 * */
//@RunWith(MockitoJUnitRunner.class)
class SomeBusinessMockTest {
	
	//create an instance of business controller with mock data
	/*
	  @InjectMocks: creates an instance of the class and injects the mocks that are created
	   with the @Mock annotation into this instance
	 */
	@InjectMocks 
	BusinessImpl businessImpl;
	
	//create a mock of SomeDataService, that will be used by @InjectMocks
	@Mock
	SomeDataService someDataService;

	// make sure we initialise mockito engine first of all
	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basicOK() {
	
		when(someDataService.retrieveAllData())
			.thenReturn(new int[] {1, 2, 3});
	
		assertEquals(6, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basicNotOK() {
	
		when(someDataService.retrieveAllData())
			.thenReturn(new int[] {1, 2, 3});

		assertNotEquals(1, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basic_emptyOK() {

		when(someDataService.retrieveAllData())
			.thenReturn(new int[] {});
				
		assertEquals(0, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basic_oneValueOK() {
			
		when(someDataService.retrieveAllData())
			.thenReturn(new int[] {100});

		assertEquals(100, businessImpl.calculateSumSomeDataService());
	}

}

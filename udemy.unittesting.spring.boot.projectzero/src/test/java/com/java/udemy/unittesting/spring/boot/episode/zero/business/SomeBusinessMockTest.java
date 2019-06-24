package com.java.udemy.unittesting.spring.boot.episode.zero.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.udemy.unittesting.spring.boot.episode.zero.services.SomeDataService;

class SomeBusinessMockTest {
	
	//create an instance of business controller
	BusinessImpl businessImpl = new BusinessImpl();
	
	//create a mock of SomeDataService
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	//launch before every test
	@BeforeEach
	public void before() {
		
		businessImpl.setSomeDataService(dataServiceMock);
		
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basicOK() {
	
		when(dataServiceMock.retrieveAllData())
			.thenReturn(new int[] {1, 2, 3});
	
		assertEquals(6, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basicNotOK() {
	
		when(dataServiceMock.retrieveAllData())
			.thenReturn(new int[] {1, 2, 3});

		assertNotEquals(1, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basic_emptyOK() {

		when(dataServiceMock.retrieveAllData())
			.thenReturn(new int[] {});
				
		assertEquals(0, businessImpl.calculateSumSomeDataService());
	}
	
	// unit testing for business method calculatedSum: OK
	@Test
	void calculateSumSomeDataService_basic_oneValueOK() {
			
		when(dataServiceMock.retrieveAllData())
			.thenReturn(new int[] {100});

		assertEquals(100, businessImpl.calculateSumSomeDataService());
	}

}

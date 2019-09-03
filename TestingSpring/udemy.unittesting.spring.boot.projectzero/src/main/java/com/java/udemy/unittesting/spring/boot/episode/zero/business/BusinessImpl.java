package com.java.udemy.unittesting.spring.boot.episode.zero.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.udemy.unittesting.spring.boot.episode.zero.services.SomeDataService;
import com.java.udemy.unittesting.spring.boot.episode.zero.services.SomeDataServiceImpl;

public class BusinessImpl {

	@Autowired
	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}


	// method to be unit tested
	public int calculateSum(int[] data) {
		
		int sum = 0;
		
		for (int value : data) {
			sum += value; 
		}
		
		return sum;
	}
	
	
	// method to be unit tested, data comes from SomeDataService
	public int calculateSumSomeDataService() {
			
		int sum = 0;
		
		//get data
		int[] data = someDataService.retrieveAllData();
		
		for (int value : data) {
			sum += value; 
		}
			
		return sum;
	}
	
}

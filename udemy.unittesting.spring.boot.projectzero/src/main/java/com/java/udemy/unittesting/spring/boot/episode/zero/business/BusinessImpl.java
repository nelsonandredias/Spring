package com.java.udemy.unittesting.spring.boot.episode.zero.business;

public class BusinessImpl {

	// method to be unit tested
	public int calculateSum(int[] data) {
		
		int sum = 0;
		
		for (int value : data) {
			sum += value; 
		}
		
		return sum;
	}
	
}

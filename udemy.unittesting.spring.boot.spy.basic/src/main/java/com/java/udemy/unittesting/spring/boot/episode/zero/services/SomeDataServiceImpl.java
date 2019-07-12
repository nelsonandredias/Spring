package com.java.udemy.unittesting.spring.boot.episode.zero.services;

import org.springframework.stereotype.Service;

@Service
public class SomeDataServiceImpl implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1,2,3};
	}

	
	
}

package udemy.learning.springframework.intro.business;

import udemy.learning.springframework.intro.data.DataService;
import udemy.learning.springframework.intro.mockito.data.DataServiceStub;

public class BusinessImpl{

	private DataService dataService;
	
	
	public BusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}


	public int findGreatestFromAllData() {
		
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for (int value:data) {
			
			if(value > greatest)
				greatest = value;
			
		}
		
		return greatest;
	}
	
}

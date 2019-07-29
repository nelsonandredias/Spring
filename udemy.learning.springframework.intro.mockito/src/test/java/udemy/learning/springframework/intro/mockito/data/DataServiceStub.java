package udemy.learning.springframework.intro.mockito.data;

import udemy.learning.springframework.intro.data.DataService;


//stub to be used by BusinessImplTest
/*
 * Ideally, we should avoid using Stubs because if we want to test different scenarios, we must
 * create a "DataServiceStub" class for each testing scenario.
 * A better solution would be using mocks.
 * */

public class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {24,6,15};
	}

	
}

package udemy.learning.mockito.business;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import udemy.learning.mockito.data.TodoService;


//@RunWith allow us to create mocks and inject it as dependencies, through @Mock and @InjectMocks, and finally make them available across testing methods
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplBDDMockTest {

	//create a mock of TodoService
	@Mock
	private TodoService todoServiceMock;
	
	//inject the mock automatically as dependency
	@InjectMocks
	TodoServiceImpl todoBusinessImpl;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDDMock() {
		
		//1. given - setup
			
			//what mock will return
			List<String> mockData = Arrays.asList("Learn Spring Core", 
						"Learn Spring MVC",
						"Learn Spring Data",
						"Learn to sleep",
						"Learn to cook");
	
			//when called this method, the test will use mock data -> dynamically stub 
			given(todoServiceMock.retrieveTodos("Spring")).willReturn(mockData);
		
		//2. when - specific business method action	
			
			List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		//3. then - 
		
			assertThat(filteredTodos.size(), is(3));
	}
	
}

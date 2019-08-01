package udemy.learning.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
public class TodoServiceImplVerifyCalls {

	//create a mock of TodoService
	@Mock
	private TodoService todoServiceMock;
	
	//inject the mock automatically as dependency
	@InjectMocks
	TodoServiceImpl todoBusinessImpl;
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDDMock() {
		
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
			
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Spring");
		
		//3. then -
			
			//verify "learn to sleep" and "learn to cook" are deleted
			verify(todoServiceMock).deleteTodo("Learn to sleep");
			then(todoServiceMock).should().deleteTodo("Learn to sleep");
			verify(todoServiceMock).deleteTodo("Learn to cook");
			then(todoServiceMock).should().deleteTodo("Learn to cook");
			
			//verify "Learn Spring Core" is never deleted
			verify(todoServiceMock , never()).deleteTodo("Learn Spring Core");
			then(todoServiceMock).should(never()).deleteTodo("Learn Spring Core");
			
			//verify "Learn to sleep" is deleted only once
			verify(todoServiceMock, times(1)).deleteTodo("Learn to sleep");
			verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to sleep");
	}
	
}

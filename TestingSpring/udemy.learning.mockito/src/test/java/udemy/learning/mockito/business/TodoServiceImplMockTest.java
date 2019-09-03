package udemy.learning.mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import udemy.learning.mockito.data.TodoService;
import udemy.learning.mockito.data.TodoServiceStub;

//@RunWith allow us to create mocks and inject it as dependencies, through @Mock and @InjectMocks, and finally make them available across testing methods
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplMockTest {

	//create a mock of TodoService
	@Mock
	private TodoService todoServiceMock;
	
	//inject the mock automatically as dependency
	@InjectMocks
	TodoServiceImpl todoBusinessImpl;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_countNumberOfSpringToDo() {
		
		//what mock will return
		List<String> mockData = Arrays.asList("Learn Spring Core", 
					"Learn Spring MVC",
					"Learn Spring Data",
					"Learn to sleep",
					"Learn to cook");

		//when called this method, the test will use mock data -> dynamically stub 
		when(todoServiceMock.retrieveTodos("Spring")).thenReturn(mockData);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(3, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_EmptyToDo() {

		//what mock will return
		List<String> mockData = Arrays.asList("");
		
		//when called this method, the test will use mock data -> dynamically stub 
		when(todoServiceMock.retrieveTodos("Spring")).thenReturn(mockData);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(0, filteredTodos.size());
	}

}

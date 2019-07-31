package udemy.learning.mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import udemy.learning.mockito.data.TodoService;
import udemy.learning.mockito.data.TodoServiceStub;

public class TodoServiceImplMockTest {

	//create a mock of TodoService
	@Mock
	private TodoService todoService;
	
	
	@Test
	public void testRetrieveTodosRelatedToSpring_countNumberOfSpringToDo() {
		
		//create a Mock of TodoService
		TodoService mockTodoService = mock(TodoService.class);
		
		//what mock will return
		List<String> mockData = Arrays.asList("Learn Spring Core", 
					"Learn Spring MVC",
					"Learn Spring Data",
					"Learn to sleep",
					"Learn to cook");

		//when called this method, the test will use mock data -> dynamically stub 
		when(mockTodoService.retrieveTodos("Spring")).thenReturn(mockData);
		
		//inject mock data in todoServiceImpl to be tested
		TodoServiceImpl todoBusinessImpl = new TodoServiceImpl(mockTodoService);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(3, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_EmptyToDo() {
		
		//create a Mock of TodoService
		TodoService mockTodoService = mock(TodoService.class);

		//what mock will return
		List<String> mockData = Arrays.asList("");
		
		//when called this method, the test will use mock data -> dynamically stub 
		when(mockTodoService.retrieveTodos("Spring")).thenReturn(mockData);
				
		//inject mock data in todoServiceImpl to be tested
		TodoServiceImpl todoBusinessImpl = new TodoServiceImpl(mockTodoService);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(0, filteredTodos.size());
	}

}

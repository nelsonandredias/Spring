package udemy.learning.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import udemy.learning.mockito.data.TodoService;

public class TodoServiceImplBDDMockTest {

	//create a mock of TodoService
	@Mock
	private TodoService todoService;
	
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDDMock() {
		
		//1. given - setup
		
			//create a Mock of TodoService
			TodoService mockTodoService = mock(TodoService.class);
			
			//what mock will return
			List<String> mockData = Arrays.asList("Learn Spring Core", 
						"Learn Spring MVC",
						"Learn Spring Data",
						"Learn to sleep",
						"Learn to cook");
	
			//when called this method, the test will use mock data -> dynamically stub 
			given(mockTodoService.retrieveTodos("Spring")).willReturn(mockData);
			
			//inject mock data in todoServiceImpl to be tested
			TodoServiceImpl todoBusinessImpl = new TodoServiceImpl(mockTodoService);
		
		//2. when - specific business method action	
			
			List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		//3. then - 
		
			assertThat(filteredTodos.size(), is(3));
	}
	
}

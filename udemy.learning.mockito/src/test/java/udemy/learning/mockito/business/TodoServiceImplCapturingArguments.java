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
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import udemy.learning.mockito.data.TodoService;

public class TodoServiceImplCapturingArguments {

	//create a mock of TodoService
	@Mock
	private TodoService todoService;
	
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDDMock_argumentCapture() {
		
		//1. given - setup
		
			//declare argument capture
			ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
			
			
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
			
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Spring");
		
		//3. then -
			
			//capturing the argument that will be deleted
			then(mockTodoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
			//verify the argument deleted are "Learn to sleep" and "Learn to cook"
			assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}
	
}

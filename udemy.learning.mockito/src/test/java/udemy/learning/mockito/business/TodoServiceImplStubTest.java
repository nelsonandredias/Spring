package udemy.learning.mockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import udemy.learning.mockito.data.TodoService;
import udemy.learning.mockito.data.TodoServiceStub;

public class TodoServiceImplStubTest {

	//all tests use Stub service with dummy data
	
	@Test
	public void testRetrieveTodosRelatedToSpring_countNumberOfSpringToDo() {
		
		//instantiate the stub service with dummy data
		TodoService todoServiceStub = new TodoServiceStub();
		
		//inject dummy data in todoServiceImpl to be tested
		TodoServiceImpl todoBusinessImpl = new TodoServiceImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(3, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_EmptyToDo() {
		
		//instantiate the stub service with dummy data
		TodoService todoServiceStub = new TodoServiceStub();
		
		//inject dummy data in todoServiceImpl to be tested
		TodoServiceImpl todoBusinessImpl = new TodoServiceImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
		assertEquals(0, filteredTodos.size());
	}

}

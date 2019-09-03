package udemy.learning.mockito.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import udemy.learning.mockito.data.TodoService;

//In order to test TodoServiceImpl, we've created a TodoServiceStub that basically returns dummy data
public class TodoServiceImpl {

	private TodoService todoService;

	
	public TodoServiceImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		
		List<String> filteredTodos = new ArrayList<String>();
		
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo:todos) {
			if (todo.contains("Spring")) filteredTodos.add(todo);
		}
			
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user){

		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo:todos) {
			if (!todo.contains("Spring")) todoService.deleteTodo(todo);
		}

	}
	
}

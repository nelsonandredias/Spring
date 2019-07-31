package udemy.learning.mockito.data;

import java.util.Arrays;
import java.util.List;


/*
 * Disadvantages of using Stubs:
 * 1. As a Stub is an implementation of an interface, it means that 
 * every time we add or delete a method in the interface, we must always update this Stub class
 * 
 * The solution for Stubs is Mocks
 * 
 * */


//stub is a class that returns dummy data
public class TodoServiceStub implements TodoService{

	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Learn Spring Core", 
							 "Learn Spring MVC",
							 "Learn Spring Data",
							 "Learn to sleep",
							 "Learn to cook");
	
	}

	public void deleteTodo(String user) {
		// TODO Auto-generated method stub
		
	}

	
	
}

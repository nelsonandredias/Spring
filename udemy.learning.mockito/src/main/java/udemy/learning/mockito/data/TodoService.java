package udemy.learning.mockito.data;

import java.util.List;

public interface TodoService {

	/*method that will return all to do of a specific subject
	 * */
	public List<String> retrieveTodos(String user);
	
	/*method that will delete a specific subject*/
	public void deleteTodo(String user);
	
	
}

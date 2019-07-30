package udemy.learning.springframework.intro.springboot.aop.data;

import org.springframework.stereotype.Component;

@Component
public class Dao2Impl implements Dao2 {

	public String retrieveSomething() {
		return "Dao2";
	}
	
}

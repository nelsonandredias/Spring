package udemy.learning.springframework.intro.springboot.aop.data;

import org.springframework.stereotype.Component;

@Component
public class Dao1Impl implements Dao1 {

	public String retrieveSomething() {
		return "Dao1";
	}
	
}

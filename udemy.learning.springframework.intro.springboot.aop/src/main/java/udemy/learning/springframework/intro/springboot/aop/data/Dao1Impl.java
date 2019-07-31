package udemy.learning.springframework.intro.springboot.aop.data;

import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.springboot.aop.configs.TrackTime1;

@Component
public class Dao1Impl implements Dao1 {

	@TrackTime1
	public String retrieveSomething() {
		return "Dao1";
	}
	
}

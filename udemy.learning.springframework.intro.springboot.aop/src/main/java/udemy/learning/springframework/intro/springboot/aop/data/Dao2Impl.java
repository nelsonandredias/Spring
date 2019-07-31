package udemy.learning.springframework.intro.springboot.aop.data;

import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.springboot.aop.configs.TrackTime2;

@Component
public class Dao2Impl implements Dao2 {

	@TrackTime2
	public String retrieveSomething() {
		return "Dao2";
	}
	
}

package udemy.learning.springframework.intro.springboot.aop.businesses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import udemy.learning.springframework.intro.springboot.aop.data.Dao2;

@Component
public class Business2Impl implements Business2{

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Dao2 dao2;
	

	public Business2Impl(Dao2 dao2) {
		super();
		this.dao2 = dao2;
	}

	
	public String calculateSomething() {
		
		LOGGER.info("calculatedSomething of Business2Impl");
		
		//business logic
		return dao2.retrieveSomething();
	} 
	
}

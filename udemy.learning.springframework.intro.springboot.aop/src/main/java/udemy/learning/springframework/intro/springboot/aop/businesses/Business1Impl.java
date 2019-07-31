package udemy.learning.springframework.intro.springboot.aop.businesses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import udemy.learning.springframework.intro.springboot.aop.data.Dao1;

@Component
public class Business1Impl implements Business1{

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Dao1 dao1;
	

	public Business1Impl(Dao1 dao1) {
		super();
		this.dao1 = dao1;
	}

	
	public String calculateSomething() {
		
		LOGGER.info("inside of Business1Impl");
		
		//business logic
		return dao1.retrieveSomething();
	} 
	
}

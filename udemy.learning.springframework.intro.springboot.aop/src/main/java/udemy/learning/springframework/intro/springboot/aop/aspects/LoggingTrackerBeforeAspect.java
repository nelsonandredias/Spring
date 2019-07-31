package udemy.learning.springframework.intro.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingTrackerBeforeAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	//@Before(Pointcut)
	/*inside @Before should be defined a pointcut:
	  execution(* PACKAGE.*.*(..))
	 * */
	//we are intercepting any method inside the package "udemy.learning.springframework.intro.springboot.aop.businesses"
	@Before("udemy.learning.springframework.intro.springboot.aop.configs.AspectConfiguration.dataLayerExecution()")
	public void before(JoinPoint join) {
		
		//this is called the advice
		LOGGER.info("@Before Method Call -> {}", join);
	}
	
	
}

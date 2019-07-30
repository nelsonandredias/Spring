package udemy.learning.springframework.intro.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingTrackerAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	//@Before(Pointcut)
	/*inside @Before should be defined a pointcut:
	  execution(* PACKAGE.*.*(..))
	 * */
	//we are intercepting any method inside the package "udemy.learning.springframework.intro.springboot.aop.businesses"
	@Before("execution(* udemy.learning.springframework.intro.springboot.aop.businesses.*.*(..))")
	public void before(JoinPoint join) {
		
		//this is called the advice
		LOGGER.info("Intercepted Method Call -> {}", join);
	}
	
	
}

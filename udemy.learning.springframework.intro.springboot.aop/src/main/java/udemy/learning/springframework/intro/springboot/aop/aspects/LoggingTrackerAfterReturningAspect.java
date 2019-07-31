package udemy.learning.springframework.intro.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingTrackerAfterReturningAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	//@AfterReturning(value=Pointcut, returning="result")
	/*inside @AfterReturning should be defined a pointcut:
	  execution(* PACKAGE.*.*(..))
	 * */
	//@AfterReturning is executed after a business method returns successfully
	@AfterReturning(
			value="execution(* udemy.learning.springframework.intro.springboot.aop.businesses.*.*(..))",
			returning="resultAfter"
			)
	public void afterReturning(JoinPoint join, Object resultAfter) {
		
		//this is called the advice
		LOGGER.info("{} @AfterReturning with value -> {}", join, resultAfter);
	}
	
	//@AfterThrowing(value=Pointcut, throwing="exception")
	/*inside @AfterThrowing should be defined a pointcut:
	 execution(* PACKAGE.*.*(..))
	* */
	//@AfterThrowing is executed after a business method returns an error
	@AfterThrowing(
			value="execution(* udemy.learning.springframework.intro.springboot.aop.businesses.*.*(..))",
			throwing="exception"
			)
	public void afterThrowing(JoinPoint join, Object exception) {
			
		//this is called the advice
		LOGGER.info("{} @AfterThrowing exception with error -> {}", join, exception);
	}
	
	
	//@After(value=Pointcut, throwing="exception")
	/*inside @After should be defined a pointcut:
		execution(* PACKAGE.*.*(..))
	* */
	//@After is executed after a business method returns successfully or an error. Basically, in both scenarios
	@After(value="execution(* udemy.learning.springframework.intro.springboot.aop.businesses.*.*(..))")
	public void after(JoinPoint join) {
				
		//this is called the advice
		LOGGER.info("{} @After execution of -> {}", join);
	}
	
}

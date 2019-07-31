package udemy.learning.springframework.intro.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionCalculationAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/*ProceedingJoinPoint allow to intercept the method call before it's executed. We are able to control method execution:
	 * we are able to trigger method execution via proceed() method*/
	
	@Around("udemy.learning.springframework.intro.springboot.aop.configs.AspectConfiguration.businessLayerExecution()")
	public Object Around(ProceedingJoinPoint join) throws Throwable {
		
		//startTime before business methods are executed
		long startTime = System.currentTimeMillis();
		
		//allow execution of method and store the result
		Object result = join.proceed();
		
		//endTime after business methods are executed
		long endTime = System.currentTimeMillis();
		
		//timeTaken
		long timeTaken = endTime-startTime;
		
		LOGGER.info("Time Taken by {} is {} -> ", join, timeTaken);
		
		return result;
	}
	
}

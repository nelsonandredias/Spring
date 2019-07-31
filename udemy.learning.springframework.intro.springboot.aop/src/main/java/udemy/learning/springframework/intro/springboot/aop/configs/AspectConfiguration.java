package udemy.learning.springframework.intro.springboot.aop.configs;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //configures Spring to recognize and use @Aspect
public class AspectConfiguration {

	//Common Pointcut configuration
	//Create generic pointcuts that will be used in Aspect classes
	
	@Pointcut("execution(* udemy.learning.springframework.intro.springboot.aop.data.*.*(..))")
	public void dataLayerExecution() {	
	}
	
	@Pointcut("execution(* udemy.learning.springframework.intro.springboot.aop.businesses.*.*(..))")
	public void businessLayerExecution() {	
	}
}

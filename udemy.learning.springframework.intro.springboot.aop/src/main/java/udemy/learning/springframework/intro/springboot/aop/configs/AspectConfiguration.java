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
	
	@Pointcut("udemy.learning.springframework.intro.springboot.aop.configs.AspectConfiguration.dataLayerExecution() && udemy.learning.springframework.intro.springboot.aop.configs.AspectConfiguration.businessLayerExecution()")
	public void allLayerExecution() {	
	}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {
	}
	
	//create pointcut with custom annotations
	
	@Pointcut("@annotation(udemy.learning.springframework.intro.springboot.aop.configs.TrackTime1)")
	public void trackTime1Annotation() {	
	}
	
	@Pointcut("@annotation(udemy.learning.springframework.intro.springboot.aop.configs.TrackTime2)")
	public void trackTime2Annotation() {}
}

package udemy.learning.springframework.intro.springboot.aop.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //configures Spring to recognize and use @Aspect
public class AspectConfiguration {

}

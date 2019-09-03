package springframework.intro.springboot.mvc.recipes;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springframework.intro.springboot.jparelations.recipes.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}

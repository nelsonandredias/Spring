package springframework.intro.springboot.mvc.recipes.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springframework.intro.springboot.jparelations.recipes.Application;
import springframework.intro.springboot.jparelations.recipes.domains.UnitOfMeasure;
import springframework.intro.springboot.jparelations.recipes.repositores.UnitOfMeasureRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	
	@Test
	public void findByDescription() throws Exception {
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uomOptional.get().getDescription());
		
	}
	
	@Test
	public void findByDescriptionCup() throws Exception {
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uomOptional.get().getDescription());
		
	}

}

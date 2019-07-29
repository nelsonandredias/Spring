package udemy.learning.springframework.intro.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeCDIBusiness {

	@Autowired
	private SomeCdiDAO someCdiDAO;

	
	public SomeCDIBusiness(SomeCdiDAO someCdiDAO) {
		super();
		this.someCdiDAO = someCdiDAO;
	}

	
	
}

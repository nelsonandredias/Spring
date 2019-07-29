package udemy.learning.springframework.intro.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class SomeCDIBusiness {

	@Inject
	private SomeCdiDAO someCdiDAO;

	
	public SomeCDIBusiness(SomeCdiDAO someCdiDAO) {
		super();
		this.someCdiDAO = someCdiDAO;
	}

	
	
}

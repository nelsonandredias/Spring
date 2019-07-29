package udemy.learning.springframework.intro.externalproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExternalProperties {

	//from property file
	@Value("${external.service.url}")
	private String url;
	
	public String returnServiceURL() {
		return url;
	}
	
}

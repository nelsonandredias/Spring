package springframework.intro.springboot.yaml.configurations;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import springframework.intro.springboot.yaml.beans.FakeDataSource;
import springframework.intro.springboot.yaml.beans.FakeJMSBroker;

@Configuration
//@EnableConfigurationProperties
public class PropertyConfig {
	
	//store property values in field
	@Value("${app.username}")
	private String user;
	@Value("${app.password}")
	private String password;
	@Value("${app.dburl}")
	private String url;
	
	@Value("${app.jms.username}")
	private String jmsUser;
	@Value("${app.jms.password}")
	private String jmsPassword;
	@Value("${app.jms.url}")
	private String jmsUrl;
	
	// fake Data Source bean to use across app
	@Bean
	public FakeDataSource fakeDataSource() {	
		FakeDataSource fakeDataSource = new FakeDataSource(user, password, url);	
		return fakeDataSource;
	}
	
	@Bean
	public FakeJMSBroker fakeJmsBroker() {
		FakeJMSBroker fakeJmsBroker = new FakeJMSBroker(jmsUser, jmsPassword, jmsUrl);
		return fakeJmsBroker;
	}
	
	// it allows to read the property file
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {	
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();	
		return propertySourcesPlaceholderConfigurer;
	}
	
}

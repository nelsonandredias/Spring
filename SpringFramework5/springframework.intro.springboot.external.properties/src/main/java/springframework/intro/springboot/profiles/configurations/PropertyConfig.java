package springframework.intro.springboot.profiles.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import springframework.intro.springboot.profiles.beans.FakeDataSource;
import springframework.intro.springboot.profiles.beans.FakeJMSBroker;

@Configuration
@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropertyConfig {
	
	//override properties based on environment
	@Autowired
	private Environment environment;
	
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
		FakeDataSource fakeDataSource = new FakeDataSource(user, environment.getProperty("PASSWORD"), url);	
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

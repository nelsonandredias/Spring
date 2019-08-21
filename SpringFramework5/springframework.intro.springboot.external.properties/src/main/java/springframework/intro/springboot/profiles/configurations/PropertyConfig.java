package springframework.intro.springboot.profiles.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import springframework.intro.springboot.profiles.beans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {
	
	//store property values in field
	@Value("${app.username}")
	private String user;
	@Value("${app.password}")
	private String password;
	@Value("${app.dburl}")
	private String url;
	
	// fake Data Source bean to use across app
	@Bean
	public FakeDataSource FakeDataSource() {	
		FakeDataSource fakeDataSource = new FakeDataSource(user, password, url);	
		return fakeDataSource;
	}
	
	// it allows to read the property file
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {	
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();	
		return propertySourcesPlaceholderConfigurer;
	}
	
}

package com.java.learning.springboot.basicsecurity.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration: indicates this class is a source of bean definition
@Configuration
//it turns on spring method level security, so we can use spring secure annotations in methods
@EnableGlobalMethodSecurity (securedEnabled = true)
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	// to configure global authentication (i.e. you only have a single AuthenticationManager) we should autowire the AuthenticationMangerBuilder
	@Autowired
	public void configGlobalAuth(AuthenticationManagerBuilder auth) throws Exception {
		
		
		// define a password encoder
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		/* set users that are authenticated 
		 * if user is not allowed an exception is throwed
		 * */
		auth
			.inMemoryAuthentication()
				.withUser("nelson")
				.password(encoder.encode("pass"))
				.roles("ADMIN")
			.and()
				.withUser("andre")
				.password(encoder.encode("pass"))
				.roles("USER");
	}

	
	//  set a security policy for "ADMIN" users
	/* set an "ADMIN" authentication for all "ADMIN" routes (anything /admin):
	 *  /admin
	 	/admin/posts
	 	/admin/posts/list
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests() //the order of authorization requests is important
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login") //set login page for authentication
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout") //set logout page 
				.permitAll();
		
	}
	
}

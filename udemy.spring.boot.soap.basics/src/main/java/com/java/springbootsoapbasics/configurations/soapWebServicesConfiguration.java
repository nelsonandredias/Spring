package com.java.springbootsoapbasics.configurations;

import java.util.Collections;
import java.util.List;

import javax.security.auth.callback.CallbackHandler;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.soap.security.xwss.callback.SpringCertificateValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// WsConfigurerAdapter -> necessary to add our Security Interceptor to the list of Interceptors

//Enable Spring Web Services
@EnableWs
//Spring Configuration File
@Configuration
public class soapWebServicesConfiguration extends WsConfigurerAdapter {

	/* MessageDispatcherServlet - its goal is to handles all the soap requests and identify the proper endpoint
	 	For that, we need to create a servletRegistrationBean where it is:
			1. defined a spring application context
			2. mapped the message servlet to a url -> /ws/*
	 */

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext) {
		
		//1. creation of the message dispatcher servlet to handle all the requests
		MessageDispatcherServlet msgDispatcherServlet = new MessageDispatcherServlet();
		
		//2. Configure the application context
		msgDispatcherServlet.setApplicationContext(appContext);
		
		//3. allow the expose of the urls set in the wsdl
		msgDispatcherServlet.setTransformWsdlLocations(true);
		
		//4. map the message servlet request to the url "/ws/*"
		return new ServletRegistrationBean(msgDispatcherServlet, "/ws/*");
	}	
	
	
	//Creation of the wsdl definition:
	/*the springwebservices will create the wsdl (authorBooks.wsdl) automatically 
		for us through the url /ws/authorBooks.wsdl based on the xsd schema "authorBooksSchema".
	*/
	@Bean(name="authorBooks") // name of the wsdl -> authorBooks.wsdl
	public DefaultWsdl11Definition defaultWsdl11Definition( XsdSchema authorBooksSchema) {
		
		DefaultWsdl11Definition defWsdl11Definition = new DefaultWsdl11Definition();
		
		//PortType -> authorBooksPort
		defWsdl11Definition.setPortTypeName("authorBooksPort");
		//Namespace -> http://springbootsoapbasics.com/getAuthorBooks
		defWsdl11Definition.setTargetNamespace("http://springbootsoapbasics.com/getAuthorBooks");
		defWsdl11Definition.setLocationUri("/ws");
		defWsdl11Definition.setSchema(authorBooksSchema());
		
		return defWsdl11Definition;
		
	}
	
	//creation of the xsdSchema to use in the wsdl definition
	@Bean
	public XsdSchema authorBooksSchema() {
		
		return new SimpleXsdSchema(new ClassPathResource("/static/xsd/getAuthorBooks.xsd"));
	}
	

	//security web service steps
	//1. Configuring XwsSecurity Interceptor
	//1.1. Define the callback handler of the XwsSecurity Interceptor: basically, what the interceptor should do when a request comes in
	//1.2. Define a security policy: create a securityPolicy.xml and configure it in interceptor
	//2. Add the created XwsSecurity Interceptor to the list of Interceptors
	
	/* XwsSecurity Interceptor: intercepts all the soap webservice requests that are comming in
	 and checks if they are secure through their userId and password
	 */
	//1. Configuring XwsSecurity Interceptor
	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		
		XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
		
		//1.1. Define the callback handler of the XwsSecurity Interceptor: basically, what the interceptor should do when a request comes in
		/*CallBack Handler -> SimplePasswordValidationCallBackHandler xwss implementation*/
		securityInterceptor.setCallbackHandler(callbackHandler());
		
		//1.2. Define a security policy: create a securityPolicy.xml and configure it in interceptor
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("static/security/securityPolicy.xml"));
		
		return securityInterceptor;
	}
	
	//whenever there is a soap request intercepted, it is checked if the combination of user and password is allowed
	@Bean
	public SimplePasswordValidationCallbackHandler callbackHandler() {
		
		SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();

		
		//Configure allowed userIds and Passwords
		handler.setUsersMap(Collections.singletonMap("user1", "password1"));
		
		return handler;
	}


	//2. Add the created XwsSecurity Interceptor to the list of Interceptors
	/*Override method of WsConfigurerAdapter
	 */
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}
		
}

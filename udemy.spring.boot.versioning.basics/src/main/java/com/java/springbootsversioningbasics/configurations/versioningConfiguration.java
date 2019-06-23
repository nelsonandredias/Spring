package com.java.springbootsversioningbasics.configurations;


import java.util.HashSet;
import java.util.Set;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
//Enable Swagger
@Configuration
@EnableSwagger2
public class versioningConfiguration {
	
	//2. set the DEFAULT_API_INFO values, as well as the DEFAULT_CONTACT
	 public static final Contact DEFAULT_CONTACT = new Contact(
			 "Nelson Dias", //name of the contact person of the API
			 "http://www.nelsondias.swaggerfilebasics.com", //website
			 "nelsondias.swaggerfilebasics@gmail.com" //email
			 );
	 public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			 "Swagger File Basics API", //title
			 "Swagger File Basics API Documentation Description", //description
			 "1.0",  //version
			 "urn:tos", //terms of service URL
	          DEFAULT_CONTACT,  //contact person of the API
	          "Apache 2.0", 
	          "http://www.apache.org/licenses/LICENSE-2.0");
	

	 //4. set the DEFAULT_PRODUCES_AND_CONSUMES values as application/json and application/xml
	 private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
				new HashSet<String>(Arrays.asList("application/json",
						"application/xml"));

	//1. Create a Bean Docket with all the configuration: all paths, apis
	// the swagger file could be seen in localhost:9090/v2/api-docs or localhost:9090/swagger-ui.html
	@Bean
	public Docket api() {
		
		/*How to add custom information to the swagger file such as api info, 
		 * the type of request/response our resources consumes
		 * and model properties validation?
		 * 1. Add the method apiInfo(DEFAULT_API_INFO) to allow a custom API information
		 * 2. set the DEFAULT_API_INFO values, as well as the DEFAULT_CONTACT
		 * 3. Add the method produces(DEFAULT_PRODUCES_AND_CONSUMES) to describe the different types of resource responses
		 * 4. set the DEFAULT_PRODUCES_AND_CONSUMES values as application/json and application/xml
		 * 5. Add the @ApiModel to the User class Model in order to set properties validation
		 * 6. set @ApiModelProperty() to each User model property
		 * */
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES);
	}

}

package com.java.learning.springboot.ymlfile.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//ConfigurationProperties POJO

@Component
@ConfigurationProperties(prefix = "my-message")
public class ConfigProperties {

	private String appName;
	private String appDescription;
	private String adminFirstName;
	private String adminLastName;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	@Override
	public String toString() {
		return String.format("ConfigProperties [appName=%s, appDescription=%s, adminFirstName=%s, adminLastName=%s]",
				appName, appDescription, adminFirstName, adminLastName);
	}
	
	
	
}

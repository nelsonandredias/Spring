package com.java.learning.springboot.basicsecurity.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	// the method access is just allowed for GUEST users
	// @Secured("ROLE_USER") it's commented because the access control is set in the securityconfiguration class
	@RequestMapping("/posts/")
	public String getAllPosts() {
		
		return "list all posts...";
		
	}
	
	
	// the method access is just allowed for ADMIN users: just admins are allowed to add posts
	//@Secured({"ROLE_ADMIN","ROLE_USER"})  it's commented because the access control is set in the securityconfiguration class
	@RequestMapping("/admin/posts/create")
	public String addPosts() {
		
		return "add posts...";
		
	}
	
	// the method access is just allowed for USER users: just USER are allowed to view drafts
	/*@Secured("ROLE_USER")
	@RequestMapping("/drafts")
	public String viewDrafts() {
		
		notSecureMethod();
		
		return "view drafts...";
			
	}
	
	private void notSecureMethod() {
		
		System.out.println("testing not secured method");
	}*/
	
}

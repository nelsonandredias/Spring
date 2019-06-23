package com.java.springbootsoapbasics.endpoints;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.java.springbootsoapbasics.exceptions.getAuthorNotFoundException;
import com.java.springbootsoapbasics.models.Authors;
import com.java.springbootsoapbasics.services.AuthorsDetailService;
import com.java.springbootsoapbasics.services.AuthorsDetailService.status;
import com.java.springbootsoapbasics.xmlJavaObjects.AuthorBooks;
import com.java.springbootsoapbasics.xmlJavaObjects.DeleteAuthorBooksRequest;
import com.java.springbootsoapbasics.xmlJavaObjects.DeleteAuthorBooksResponse;
import com.java.springbootsoapbasics.xmlJavaObjects.GetAllAuthorBooksRequest;
import com.java.springbootsoapbasics.xmlJavaObjects.GetAllAuthorBooksResponse;
import com.java.springbootsoapbasics.xmlJavaObjects.GetAuthorBooksRequest;
import com.java.springbootsoapbasics.xmlJavaObjects.GetAuthorBooksResponse;
import com.java.springbootsoapbasics.xmlJavaObjects.Status;


// @Endpoint - annotation to specify that this bean is an endpoint
@Endpoint
public class getAuthorBooksEndpoints {
	
	@Autowired
	private AuthorsDetailService authorDetailService;
	
	
	// @PayloadRoot -> if request comes with the namespace-> http://springbootsoapbasics.com/getAuthorBooks
	// and the name "GetAuthorBooksRequest", then this method is called:
	
	// @RequestPayload -> it converts the xml request into a java object
	// @ResponsePayload -> it converts the java response back to a xml
	
	//1.endpoint to getAuthorById
	@PayloadRoot(namespace="http://springbootsoapbasics.com/getAuthorBooks", 
			localPart="getAuthorBooksRequest")
	@ResponsePayload 
	public GetAuthorBooksResponse getSingleAuthorBookDetailsRequest 
		(@RequestPayload GetAuthorBooksRequest getAuthorBooksRequest) {
			
		Authors author = authorDetailService.findById(getAuthorBooksRequest.getId());
		
		// error handling - invalid author id
		if(author == null) {
			throw new getAuthorNotFoundException("Invalid authorID= " + getAuthorBooksRequest.getId());
		}
		
		return mapAuthorBooksDetails(author);
	}

	//2.endpoint to getAllAuthors
	@PayloadRoot(namespace="http://springbootsoapbasics.com/getAuthorBooks", 
			localPart="getAllAuthorBooksRequest")
	@ResponsePayload 
	public GetAllAuthorBooksResponse getAllAuthorsDetailsRequest 
		(@RequestPayload GetAllAuthorBooksRequest getAllAuthorBooksRequest) {
				
		List<Authors> authors = authorDetailService.getAllAuthorDetails();
			
		return mapAllAuthorBooksDetails(authors);
	}
	
	//2.endpoint to delteAuthor
	@PayloadRoot(namespace="http://springbootsoapbasics.com/getAuthorBooks", 
			localPart="deleteAuthorBooksRequest")
	@ResponsePayload 
	public DeleteAuthorBooksResponse deleteAuthorDetailsRequest 
		(@RequestPayload DeleteAuthorBooksRequest deleteAuthorBooksRequest) {
					
		status status = authorDetailService.deleteAuthor(deleteAuthorBooksRequest.getId());
				
		DeleteAuthorBooksResponse response = new DeleteAuthorBooksResponse();
		
		response.setStatus(mapStatus(status));
		
		return response;
	}
	
		private Status mapStatus(status status) {
		
			if(status == status.SUCCESS) {
				return Status.SUCCESS;
			}
			
		return Status.FAILURE;
	}

		private GetAuthorBooksResponse mapAuthorBooksDetails(Authors author) {
			
			GetAuthorBooksResponse response = new GetAuthorBooksResponse();
			
			AuthorBooks authorBooks = mapAuthorBook(author);
			
			response.setAuthorBooks(authorBooks);
			
			return response;
		}
		
		private GetAllAuthorBooksResponse mapAllAuthorBooksDetails(List<Authors> authors) {
			
			GetAllAuthorBooksResponse response = new GetAllAuthorBooksResponse();
			
			for(Authors author: authors) {
				
				AuthorBooks mapAuthor = mapAuthorBook(author);
				response.getAuthorBooks().add(mapAuthor);
			}
			
			return response;
		}

		private AuthorBooks mapAuthorBook(Authors author) {
			
			AuthorBooks authorBooks = new AuthorBooks();
			
			authorBooks.setId(author.getId());
			authorBooks.setAuthor(author.getAuthor());
			authorBooks.setBook(author.getBook());
			
			return authorBooks;
		}


}

package com.java.springbootresth2basics.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.springbootresth2basics.entities.Author;
import com.java.springbootresth2basics.entities.Book;
import com.java.springbootresth2basics.exceptions.EntityNotFoundException;
import com.java.springbootresth2basics.services.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthors() throws Exception{

		List<Author> authors = authorService.retrieveAllAuthors();
			
		if(authors.isEmpty()) {
			//set an error message
			throw new Exception("Unable to get authors");
		}
			
		return ResponseEntity.ok(authors);
		
	}
	
	@GetMapping("/authors/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable int id) throws EntityNotFoundException, Exception{
		

			Author author = authorService.retrieveAuthorByID(id)
					.orElseThrow(() -> new EntityNotFoundException("id = " + id));
			
			return ResponseEntity.ok(author);
		
		
	}
	
	@GetMapping("/authors/{id}/books")
	public ResponseEntity<List<Book>> getBooksFromAuthor(@PathVariable int id) throws EntityNotFoundException, Exception{
		
		try {

			Optional<Author> authorOptional = authorService.retrieveAuthorByID(id);
			
			List<Book> authorBooks = authorOptional.get().getBooks();
			
			if(authorBooks.isEmpty()) {
				throw new Exception("Unable to get books from author");
			}
			
			return ResponseEntity.ok(authorBooks);
			
		}catch(EntityNotFoundException entityNotFound) {
			
			throw new EntityNotFoundException("id = " + id);
		
		}catch(Exception e) {
			
			throw new Exception("Unable to get books from author");
			
		}
		
	}
	
	//input - details of a new author
	//output - CREATED and return the created URI
	
	@PostMapping("/authors")
	public ResponseEntity<Object> createNewAuthor(@Valid @RequestBody Author author) {
		
		Author savedAuthor = authorService.saveAuthor(author);
		
		/*1. define the URI location of the new user resource -> /authors/{id}:
	 	How? 
		Take the request URI (/authors) and append the new author ID (savedAuthor.getId())
		a. ServletUriComponentsBuilder
		.fromCurrentRequest() -> returns the current request URI : /authors
		b. .path("/{id}") -> append the "/{id}" to the current request URI ("/authors")
		c. .buildAndExpand(savedAuthor.getId()) -> replace the append "{id}" by the new author ID
		d. .toUri() -> convert the result into a URI
		*/
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedAuthor.getId()).toUri();
		
		/*ResponseEntity -> Allow to return the Response State Code of "201" along with the URI user resource created: /authors/{id} 
		*/
		return  ResponseEntity
				.created(location)
				.body(savedAuthor);
	
	}
	
	//update all existing author fields
	@PutMapping("/authors/{id}")
	public Author fullUpdateAuthor(@PathVariable int id, @Valid @RequestBody Author author) {
		
		Author existingAuthor = authorService.retrieveAuthorByID(id)
										.orElseThrow(() -> new EntityNotFoundException("id = " + id));
			
		//update existingAuthor fields - change for a DTO
		existingAuthor.setName(author.getName());
		existingAuthor.setNationality(author.getNationality());
		existingAuthor.setBirthdate(author.getBirthdate());
			
		authorService.saveAuthor(existingAuthor);
			
		return existingAuthor;
		
	}
	
	
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable int id) {
		
		authorService.deleteAuthor(id);
		
	}

}

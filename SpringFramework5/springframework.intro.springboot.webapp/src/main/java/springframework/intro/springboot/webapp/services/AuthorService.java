package springframework.intro.springboot.webapp.services;

import springframework.intro.springboot.webapp.models.Author;

public interface AuthorService {

	public Iterable<Author> getAllAuthors();
	
}

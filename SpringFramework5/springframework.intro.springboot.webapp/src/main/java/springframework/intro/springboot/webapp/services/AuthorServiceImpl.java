package springframework.intro.springboot.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.webapp.models.Author;
import springframework.intro.springboot.webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Iterable<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

}

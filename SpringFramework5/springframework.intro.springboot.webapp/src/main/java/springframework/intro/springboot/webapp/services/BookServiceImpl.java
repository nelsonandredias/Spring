package springframework.intro.springboot.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.intro.springboot.webapp.models.Book;
import springframework.intro.springboot.webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}

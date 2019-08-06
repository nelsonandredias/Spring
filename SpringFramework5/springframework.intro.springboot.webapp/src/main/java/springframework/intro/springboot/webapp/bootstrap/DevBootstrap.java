package springframework.intro.springboot.webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import springframework.intro.springboot.webapp.models.Author;
import springframework.intro.springboot.webapp.models.Book;
import springframework.intro.springboot.webapp.models.Publisher;
import springframework.intro.springboot.webapp.repositories.AuthorRepository;
import springframework.intro.springboot.webapp.repositories.BookRepository;
import springframework.intro.springboot.webapp.repositories.PublisherRepository;

/* Populate database during app initialization
 * 
 * */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	
	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();		
	}
	
	
	private void initData() {
		
		//Publishers
		Publisher firstPublisher = new Publisher("Publisher 1", "Street of Heaven");
		Publisher secondPublisher = new Publisher("Publisher 2", "Down Hill");
		
		publisherRepository.save(firstPublisher);
		publisherRepository.save(secondPublisher);
		
		//Nelson
		Author nelson = new Author("Nelson", "Dias");
		Book firstBook = new Book("Domain Driven Design", "1234", firstPublisher);	
		
		nelson.getBooks().add(firstBook);
		firstBook.getAuthors().add(nelson);
		
		authorRepository.save(nelson);
		bookRepository.save(firstBook);
		
		
		//Andre
		Author andre = new Author("Andre", "Silva");
		Book noEJB = new Book("Spring Development", "222233334", secondPublisher);	
				
		andre.getBooks().add(noEJB);
		noEJB.getAuthors().add(andre);
		
		authorRepository.save(andre);
		bookRepository.save(noEJB);
		
		
	}

	
	
}

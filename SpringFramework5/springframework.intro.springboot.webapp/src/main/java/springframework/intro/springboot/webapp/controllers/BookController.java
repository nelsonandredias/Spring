package springframework.intro.springboot.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springframework.intro.springboot.webapp.models.Book;
import springframework.intro.springboot.webapp.services.BookService;

@Controller
public class BookController {

	private BookService bookService;
	
	
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}



	@GetMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookService.getAllBooks());
		//return bookService.getAllBooks();
		return "books";
	}
	
}

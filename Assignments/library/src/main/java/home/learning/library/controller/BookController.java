package home.learning.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import home.learning.library.model.BookModel;
import home.learning.library.model.CreateBookRequest;
import home.learning.library.model.CreateBookResponse;
import home.learning.library.model.GetBookResponse;
import home.learning.library.model.GetBooksResponse;
import home.learning.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public GetBooksResponse getBooks() {
		List<BookModel> booksList = bookService.getBooks();
		return new GetBooksResponse(booksList);
	
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public GetBookResponse getBook(@PathVariable(name = "id") int id) {
		BookModel author = bookService.getBook(id);
		return new GetBookResponse(author);
		
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable(name="id") int id) {
		bookService.deleteBook(id);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateBookResponse createBook(@RequestBody CreateBookRequest request) {
		BookModel author = bookService.createBook(request.getTitle(), request.getDescription(), request.getAuthors());
		return new CreateBookResponse(author);
		
	}
}

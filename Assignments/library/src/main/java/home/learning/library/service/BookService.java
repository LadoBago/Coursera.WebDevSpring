package home.learning.library.service;

import java.util.List;
import java.util.Set;

import home.learning.library.model.BookModel;

public interface BookService {
	BookModel getBook(int id);
	List<BookModel> getBooks();
	void deleteBook(int id);
	BookModel createBook(String title, String description, Set<String> authors);

}

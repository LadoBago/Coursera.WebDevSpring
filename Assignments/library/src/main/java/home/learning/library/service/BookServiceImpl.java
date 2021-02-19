package home.learning.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import home.learning.library.entity.AuthorEntity;
import home.learning.library.entity.BookEntity;
import home.learning.library.model.BookModel;
import home.learning.library.repository.AuthorRepository;
import home.learning.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final Converter<BookEntity, BookModel> converter;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, Converter<BookEntity, BookModel> converter) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.converter = converter;				
	}

	@Override
	public BookModel getBook(int id) {
		
		Optional<BookEntity> book = bookRepository.findById(id);
		
		if (book.isPresent()) {
			BookEntity entity = book.get();
			return converter.convert(entity);
		}
		
		return null;
	}

	@Override
	public List<BookModel> getBooks() {
		
		List<BookEntity> list = bookRepository.findAll();
		List<BookModel> res = new ArrayList<>();
		
		for (BookEntity entity: list) {
			res.add(converter.convert(entity));
		}
		
		return res;
	}

	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public BookModel createBook(String title, String description, Set<String> authors) {
		
		BookEntity bookEntity = new BookEntity();
		bookEntity.setTitle(title);
		bookEntity.setDescription(description);
		
		for (String name: authors) {
		
			List<AuthorEntity> authorEntityList = authorRepository.findByName(name);
			AuthorEntity authorEntity;
			if (authorEntityList == null || authorEntityList.size() == 0) {
				AuthorEntity tmpAuthorEntity = new AuthorEntity();
				tmpAuthorEntity.setName(name);
				authorEntity = authorRepository.save(tmpAuthorEntity);
			}
			else {
				authorEntity = authorEntityList.get(0);
			}
			
			bookEntity.getAuthors().add(authorEntity);
		}
		
		BookEntity savedBookEntity = bookRepository.save(bookEntity);
		
		return converter.convert(savedBookEntity);
	}

}

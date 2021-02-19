package home.learning.library.converter;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import home.learning.library.entity.AuthorEntity;
import home.learning.library.entity.BookEntity;
import home.learning.library.model.BookModel;

@Service
public class BookEntityToBookModelConverter implements Converter<BookEntity, BookModel> {

	@Override
	public BookModel convert(BookEntity source) {
		
		if (source == null) {
			return null;
		}

		BookModel res = new BookModel(source.getId(), source.getTitle(), source.getDescription(), new ArrayList<String>());
		
		for (AuthorEntity author: source.getAuthors()) {
			res.getAuthors().add(author.getName());
		}
		
		return res;
	}

}

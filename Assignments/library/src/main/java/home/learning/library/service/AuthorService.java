package home.learning.library.service;

import java.util.List;

import home.learning.library.model.AuthorModel;

public interface AuthorService {
	AuthorModel getAuthor(int id);
	List<AuthorModel> getAuthors();
	void deleteAuthors(int id);
	AuthorModel createAuthor(String name);
}

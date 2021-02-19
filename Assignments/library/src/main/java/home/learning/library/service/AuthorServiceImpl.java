package home.learning.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import home.learning.library.entity.AuthorEntity;
import home.learning.library.model.AuthorModel;
import home.learning.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository, Converter<AuthorEntity, AuthorModel> converter) {
		this.authorRepository = authorRepository;
		this.converter = converter;
	}

	private final AuthorRepository authorRepository;
	private final Converter<AuthorEntity, AuthorModel> converter;
	
	@Override
	public AuthorModel getAuthor(int id) {
		
		Optional<AuthorEntity> author = authorRepository.findById(id);
		
		if (author.isPresent()) {
			AuthorEntity entity = author.get();
			return converter.convert(entity);
		}
		
		return null;
	}

	@Override
	public List<AuthorModel> getAuthors() {
		
		List<AuthorEntity> list = authorRepository.findAll();
		List<AuthorModel> res = new ArrayList<>();
		
		for (AuthorEntity entity: list) {
			res.add(converter.convert(entity));
		}
		
		return res;
	}

	@Override
	public void deleteAuthors(int id) {
		authorRepository.deleteById(id);
	}

	@Override
	public AuthorModel createAuthor(String name) {
		
		AuthorEntity entity = new AuthorEntity();
		entity.setName(name);
		
		AuthorEntity savedEntity = authorRepository.save(entity);
		
		return converter.convert(savedEntity);
	}

}

package home.learning.library.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import home.learning.library.entity.AuthorEntity;
import home.learning.library.model.AuthorModel;

@Service
public class AuthorEntityToAuthorModelConverter implements Converter<AuthorEntity, AuthorModel> {

	@Override
	public AuthorModel convert(AuthorEntity source) {
		
		if (source == null)
			return null;
		
		return new AuthorModel(source.getId(), source.getName());
	}

}

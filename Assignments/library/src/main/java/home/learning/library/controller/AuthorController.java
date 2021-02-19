package home.learning.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import home.learning.library.model.AuthorModel;
import home.learning.library.model.CreateAuthorRequest;
import home.learning.library.model.CreateAuthorResponse;
import home.learning.library.model.GetAuthorResponse;
import home.learning.library.model.GetAuthorsResponse;
import home.learning.library.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	private AuthorService authorService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public GetAuthorsResponse getAuthors() {
		List<AuthorModel> authorsList = authorService.getAuthors();
		return new GetAuthorsResponse(authorsList);
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public GetAuthorResponse getAuthor(@PathVariable(name = "id") int id) {
		AuthorModel author = authorService.getAuthor(id);
		return new GetAuthorResponse(author);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAuthor(@PathVariable(name="id") int id) {
		authorService.deleteAuthors(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAuthorResponse createAuthor(@RequestBody CreateAuthorRequest request) {
		AuthorModel author = authorService.createAuthor(request.getName());
		return new CreateAuthorResponse(author);
	}

}

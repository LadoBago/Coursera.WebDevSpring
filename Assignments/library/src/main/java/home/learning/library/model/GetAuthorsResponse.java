package home.learning.library.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAuthorsResponse {
	
	private List<AuthorModel> authors = new ArrayList<>();

}

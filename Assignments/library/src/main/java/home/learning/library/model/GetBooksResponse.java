package home.learning.library.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBooksResponse {

	private List<BookModel> books;
}

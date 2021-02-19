package home.learning.library.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookRequest {
	
	private String title;
	private String description;
	
	private Set<String> authors;
	

}

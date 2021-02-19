package home.learning.library.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class AuthorEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name="author_id") }, inverseJoinColumns = {@JoinColumn(name = "book_id")})
	private Set<BookEntity> books;
	
	public AuthorEntity() {
		this.books = new HashSet<BookEntity>();
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.id.equals(obj);
	}
	
}

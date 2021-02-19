package home.learning.library.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
public class BookEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name="book_id") }, inverseJoinColumns = {@JoinColumn(name = "author_id")})
	private Set<AuthorEntity> authors;
	
	public BookEntity() {
		this.authors = new HashSet<AuthorEntity>();
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

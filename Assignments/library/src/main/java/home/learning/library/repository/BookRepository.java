package home.learning.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.learning.library.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}

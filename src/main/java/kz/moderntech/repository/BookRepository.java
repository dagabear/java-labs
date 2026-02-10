package kz.moderntech.repository;

import kz.moderntech.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByAuthor(String author);
}

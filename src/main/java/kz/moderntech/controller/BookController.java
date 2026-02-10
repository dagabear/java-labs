package kz.moderntech.controller;

import jakarta.validation.constraints.NotBlank;
import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Book;
import kz.moderntech.repository.BookRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController extends BaseController<Book, Long> {

    private final BookRepository bookRepository;

    public BookController(BookRepository repository) {
        super(repository);
        this.bookRepository = repository;
    }

    @GetMapping("/{author}")
    public List<Book> getBooksByAuthor(@PathVariable @NotBlank String author) {
        return bookRepository.findBooksByAuthor(author);
    }

}

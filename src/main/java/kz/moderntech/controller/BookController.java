package kz.moderntech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
}

// id, title, author, year - books (get books by author)
// id, fullname, course (get st by course) - student
// id, name, price - product
// title, completed - todo
// user with dto
package com.amm.cloud.basic.bk.bookservice.interfaces;

import com.amm.cloud.basic.bk.bookservice.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> bookList = Arrays.asList(
            new Book(1L, "First Author", "one title"),
            new Book(2L, "Second Author", "two title")
    );

    @GetMapping("")
    public List<Book> findAllBooks() {
        return bookList;
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
    }
}

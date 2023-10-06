package com.example.Book.Controller;

import com.example.Book.Entity.Author;
import com.example.Book.Entity.Book;
import com.example.Book.Service.AuthorService;
import com.example.Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book,@RequestParam("authorId") Integer authorId) {
        String result = bookService.addBook(book,authorId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}

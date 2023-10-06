package com.example.Book.Controller;


import com.example.Book.Entity.Author;
import com.example.Book.Entity.Book;
import com.example.Book.Repository.AuthorRepository;
import com.example.Book.Service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublishService publishService;


    @PostMapping("/{authorId}/{yearOfPublication}")
    public ResponseEntity publishBook(@RequestBody Book book, @PathVariable Integer authorId, @PathVariable Integer yearOfPublication) {
        try {
            Optional<Author> optionalAuthor = authorRepository.findById(authorId);
            Author author = optionalAuthor.get();
            String result = publishService.publishBook(book, author, yearOfPublication);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error{}",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }


    }

    @GetMapping("/count-books/{authorId}/{year}")
    public long countBooksPublishedByAuthorInYear(@PathVariable Integer authorId, @PathVariable Integer year) {

        try {
            Optional<Author> optionalAuthor = authorRepository.findById(authorId);
            Author author = optionalAuthor.get();
            return publishService.countBooksPublishedByAuthorInYear(author, year);
        }
        catch (Exception e){
            log.error("Error{}",e.getMessage());
            return -1;
        }

    }

}

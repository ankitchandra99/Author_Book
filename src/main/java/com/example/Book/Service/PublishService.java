package com.example.Book.Service;

import com.example.Book.Entity.Author;
import com.example.Book.Entity.Book;
import com.example.Book.Entity.Publish;
import com.example.Book.Repository.AuthorRepository;
import com.example.Book.Repository.BookRepository;
import com.example.Book.Repository.PublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublishService {

    @Autowired
    private PublishRepository publishRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    public String publishBook(Book book, Author optionalAuthor, Integer yearOfPublication){
        Publish publish = new Publish();
        publish.setBook(book);
        publish.setAuthor(optionalAuthor);
        publish.setYearOfPublication(yearOfPublication);
        book.setAuthor(optionalAuthor);
        authorRepository.save(optionalAuthor);
        bookRepository.save(book);
        publishRepository.save(publish);
        return "Publish record is saved";
    }

    public long countBooksPublishedByAuthorInYear(Author author, int year) {
        return authorRepository.countByBooksAuthorAndYearOfPublication(author, year);
    }
}

package com.example.Book.Service;


import com.example.Book.Entity.Author;
import com.example.Book.Entity.Book;
import com.example.Book.Repository.AuthorRepository;
import com.example.Book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book,Integer authorId){
        // You can add validation logic here if needed.\
        Optional<Author> optionalAuthor=authorRepository.findById(authorId);

        Author author=optionalAuthor.get();
        book.setAuthor(author);
        List<Book> list = author.getBookList();
        list.add(book);
        author.setBookList(list);
        authorRepository.save(author);
        return "book is added";
    }
}

package com.example.Book.Service;

import com.example.Book.Entity.Author;
import com.example.Book.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
     private AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added";
    }
}

package com.example.Book.Controller;

import com.example.Book.Entity.Author;
import com.example.Book.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String result=authorService.addAuthor(author);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}

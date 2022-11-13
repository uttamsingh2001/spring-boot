package com.test.simplemappingdemo.controller;

import com.test.simplemappingdemo.model.BookRequest;
import com.test.simplemappingdemo.model.BookResponse;
import com.test.simplemappingdemo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   @PostMapping(value = "/books",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest)
    {
        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
    }
}

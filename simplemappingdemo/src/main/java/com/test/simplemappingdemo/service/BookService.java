package com.test.simplemappingdemo.service;

import com.test.simplemappingdemo.entity.AuthorEntity;
import com.test.simplemappingdemo.entity.BookEntity;
import com.test.simplemappingdemo.model.AuthorRequest;
import com.test.simplemappingdemo.model.BookRequest;
import com.test.simplemappingdemo.model.BookResponse;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookService {

    public BookResponse createBook(BookRequest bookRequest) {

        BookEntity bookEntity=new BookEntity();
        bookEntity.setName(bookRequest.getName());


        bookEntity.setAuthor();
    }
}

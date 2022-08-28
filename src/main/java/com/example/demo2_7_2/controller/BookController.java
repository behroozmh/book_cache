package com.example.demo2_7_2.controller;

import com.example.demo2_7_2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getList")
    public ResponseEntity getList(){
        return ResponseEntity.ok(bookService);
    }
}

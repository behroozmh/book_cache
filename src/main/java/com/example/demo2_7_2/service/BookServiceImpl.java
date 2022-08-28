package com.example.demo2_7_2.service;

import com.example.demo2_7_2.dao.BookDAO;
import com.example.demo2_7_2.entity.Book;
import com.example.demo2_7_2.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<BookDTO> getList() {
        Iterable<Book> lst = bookDAO.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        return bookDTOS;
    }
}

package ir.behi.book_cache.service;

import ir.behi.book_cache.dao.BookDAO;
import ir.behi.book_cache.entity.Book;
import ir.behi.book_cache.model.BookDTO;
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

package ir.behi.book_cache.service;

import ir.behi.book_cache.model.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getList();
}

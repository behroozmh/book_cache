package ir.behi.book_cache.service;

import ir.behi.book_cache.dao.BookDAO;
import ir.behi.book_cache.entity.Book;
import ir.behi.book_cache.mapper.BookMapper;
import ir.behi.book_cache.model.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    public BookServiceImpl(BookDAO bookDAO, BookMapper bookMapper) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
    }

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    @Override
    public List<BookDTO> getList() {
        return bookMapper.ToDTOs(bookDAO.findAll());
    }

    @Override
    public BookDTO get(Integer id) {
        Optional<Book> book = bookDAO.findById(id);
        if (book.isPresent())
            return bookMapper.ToDTO(book.get());
        else return null;
    }

    @Override
    public BookDTO addOrUpdate(BookDTO book) {
        return bookMapper.ToDTO(bookDAO.save(bookMapper.ToEntity(book)));
    }
}

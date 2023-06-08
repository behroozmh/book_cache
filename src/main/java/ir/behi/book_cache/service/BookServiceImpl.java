package ir.behi.book_cache.service;

import ir.behi.book_cache.dao.BookDAO;
import ir.behi.book_cache.entity.Book;
import ir.behi.book_cache.mapper.BookMapper;
import ir.behi.book_cache.model.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * this class implement in memory cache with spring annotation method level
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    public BookServiceImpl(BookDAO bookDAO, BookMapper bookMapper, CacheManager cacheManager) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
        this.cacheManager = cacheManager;
    }

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;
    private final CacheManager cacheManager;

    @Cacheable(value = "books")
    @Override
    public List<BookDTO> getList() {
        if (log.isDebugEnabled()) {
            Cache cache = cacheManager.getCache("books");
            if (cache != null) {
                log.debug("load from cache");
                return (List<BookDTO>) cache.get("books");
            } else {
                log.debug("load from database");
                return bookMapper.ToDTOs(bookDAO.findAll());
            }
        }
        return bookMapper.ToDTOs(bookDAO.findAll());
    }

    @Cacheable(value = "book", key = "#id")
    @Override
    public BookDTO get(Integer id) {
        Optional<Book> book = bookDAO.findById(id);
        if (book.isPresent()) return bookMapper.ToDTO(book.get());
        else return null;
    }

    @Caching(put = {@CachePut(value = "book", key = "#book.id")},
            evict = {@CacheEvict(value = "books", allEntries = true)})
    @Override
    public BookDTO addOrUpdate(BookDTO book) {
        return bookMapper.ToDTO(bookDAO.save(bookMapper.ToEntity(book)));
    }

    @Caching(evict = {
            @CacheEvict(value = "book", key = "#book.id"),
            @CacheEvict(value = "books", allEntries = true)
    }
    )
    @Override
    public void delete(int id) {
        bookDAO.deleteById(id);
    }
}

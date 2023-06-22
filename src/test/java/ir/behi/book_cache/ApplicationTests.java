package ir.behi.book_cache;

import ir.behi.book_cache.dao.BookDAO;
import ir.behi.book_cache.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collection;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    void contextLoads() {
        Iterable<Book> lst = bookDAO.findAll();
        Assert.notEmpty((Collection<?>) lst,"ttt");
    }

}

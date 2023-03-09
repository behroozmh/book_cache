package ir.behi.book_cache.dao;

import ir.behi.book_cache.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends CrudRepository<Book, Integer> {
}

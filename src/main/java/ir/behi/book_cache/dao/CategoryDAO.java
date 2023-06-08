package ir.behi.book_cache.dao;

import ir.behi.book_cache.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {
}

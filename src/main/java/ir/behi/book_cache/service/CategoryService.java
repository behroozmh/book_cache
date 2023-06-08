package ir.behi.book_cache.service;

import ir.behi.book_cache.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getList();
    CategoryDTO get(Integer id);
    CategoryDTO addOrUpdate(CategoryDTO category);
    void delete(int id);
}

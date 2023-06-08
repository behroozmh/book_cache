package ir.behi.book_cache.service;

import ir.behi.book_cache.dao.CategoryDAO;
import ir.behi.book_cache.entity.Category;
import ir.behi.book_cache.mapper.CategoryMapper;
import ir.behi.book_cache.model.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    public CategoryServiceImpl(CategoryDAO categoryDAO, CategoryMapper categoryMapper, CacheManager cacheManager) {
        this.categoryDAO = categoryDAO;
        this.categoryMapper = categoryMapper;
        this.cacheManager = cacheManager;
    }

    private final CategoryDAO categoryDAO;
    private final CategoryMapper categoryMapper;
    private final CacheManager cacheManager;


    @Override
    public List<CategoryDTO> getList() {
        return categoryMapper.ToDTOs(categoryDAO.findAll());
    }

    @Override
    public CategoryDTO get(Integer id) {
        Optional<Category> category = categoryDAO.findById(id);
        if (category.isPresent()) return categoryMapper.ToDTO(category.get());
        else return null;
    }

    @Override
    public CategoryDTO addOrUpdate(CategoryDTO category) {
        return categoryMapper.ToDTO(categoryDAO.save(categoryMapper.ToEntity(category)));
    }

    @Override
    public void delete(int id) {
        categoryDAO.deleteById(id);
    }
}

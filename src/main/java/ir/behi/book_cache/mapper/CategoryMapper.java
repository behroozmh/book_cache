package ir.behi.book_cache.mapper;

import ir.behi.book_cache.entity.Category;
import ir.behi.book_cache.model.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category ToEntity(CategoryDTO model);

    CategoryDTO ToDTO(Category entity);

    default List<Category> ToEntities(List<CategoryDTO> models) {
        if (models != null & models.size() > 0) {
            List<Category> entities = new ArrayList<>();
            for (CategoryDTO model : models)
                entities.add(ToEntity(model));
            return entities;
        } else return new ArrayList<>();
    }

    default List<CategoryDTO> ToDTOs(List<Category> entities) {
        if (entities != null & entities.size() > 0) {
            List<CategoryDTO> models = new ArrayList<>();
            for (Category entity : entities)
                models.add(ToDTO(entity));
            return models;
        } else return new ArrayList<>();
    }

    default List<CategoryDTO> ToDTOs(Iterable<Category> entities) {
        if (entities != null & entities.iterator().hasNext()) {
            List<CategoryDTO> models = new ArrayList<>();
            for (Category entity : entities)
                models.add(ToDTO(entity));
            return models;
        } else return new ArrayList<>();
    }
}

package ir.behi.book_cache.mapper;

import ir.behi.book_cache.entity.Category;
import ir.behi.book_cache.model.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDTO model);

    CategoryDTO toDTO(Category entity);

    default List<Category> toEntities(List<CategoryDTO> models) {
        if (models != null && models.isEmpty() ) {
            List<Category> entities = new ArrayList<>();
            for (CategoryDTO model : models)
                entities.add(toEntity(model));
            return entities;
        } else return new ArrayList<>();
    }

    default List<CategoryDTO> toDTOs(List<Category> entities) {
        if (entities != null && entities.isEmpty()) {
            List<CategoryDTO> models = new ArrayList<>();
            for (Category entity : entities)
                models.add(toDTO(entity));
            return models;
        } else return new ArrayList<>();
    }

    default List<CategoryDTO> toDTOs(Iterable<Category> entities) {
        if (entities != null && entities.iterator().hasNext()) {
            List<CategoryDTO> models = new ArrayList<>();
            for (Category entity : entities)
                models.add(toDTO(entity));
            return models;
        } else return new ArrayList<>();
    }
}

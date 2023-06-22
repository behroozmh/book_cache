package ir.behi.book_cache.mapper;

import ir.behi.book_cache.entity.Book;
import ir.behi.book_cache.model.BookDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDTO model);

    BookDTO toDTO(Book entity);

    default List<Book> toEntities(List<BookDTO> models) {
        if (models != null && models.isEmpty()) {
            List<Book> entities = new ArrayList<>();
            for (BookDTO model : models)
                entities.add(toEntity(model));
            return entities;
        } else return new ArrayList<>();
    }

    default List<BookDTO> toDTOs(List<Book> entities) {
        if (entities != null && entities.isEmpty()) {
            List<BookDTO> models = new ArrayList<>();
            for (Book entity : entities)
                models.add(toDTO(entity));
            return models;
        } else return new ArrayList<>();
    }

    default List<BookDTO> toDTOs(Iterable<Book> entities) {
        if (entities != null && entities.iterator().hasNext()) {
            List<BookDTO> models = new ArrayList<>();
            for (Book entity : entities)
                models.add(toDTO(entity));
            return models;
        } else return new ArrayList<>();
    }
}

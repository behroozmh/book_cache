package ir.behi.book_cache.mapper;

import ir.behi.book_cache.entity.Book;
import ir.behi.book_cache.model.BookDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book ToEntity(BookDTO model);

    BookDTO ToDTO(Book entity);

    default List<Book> ToEntities(List<BookDTO> models) {
        if (models != null & models.size() > 0) {
            List<Book> entities = new ArrayList<>();
            for (BookDTO model : models)
                entities.add(ToEntity(model));
            return entities;
        } else return new ArrayList<>();
    }

    default List<BookDTO> ToDTOs(List<Book> entities) {
        if (entities != null & entities.size() > 0) {
            List<BookDTO> models = new ArrayList<>();
            for (Book entity : entities)
                models.add(ToDTO(entity));
            return models;
        } else return new ArrayList<>();
    }

    default List<BookDTO> ToDTOs(Iterable<Book> entities) {
        if (entities != null & entities.iterator().hasNext()) {
            List<BookDTO> models = new ArrayList<>();
            for (Book entity : entities)
                models.add(ToDTO(entity));
            return models;
        } else return new ArrayList<>();
    }
}

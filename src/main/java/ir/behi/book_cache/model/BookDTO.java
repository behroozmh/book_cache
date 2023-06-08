package ir.behi.book_cache.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BookDTO {
    private Integer id;
    private String name;
    private String enName;
    private String isbn;
    private UUID uuid;
    private Date printDate;
    private Integer version;
    private String publisher;
}

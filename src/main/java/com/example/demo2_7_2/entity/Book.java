package com.example.demo2_7_2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "Book")
@Table(name = "Book")
public class Book {
    @Id
    private Integer id;
    private String name;
    private String enName;
    private String isbn;
    private UUID uuid;
    private Date printDate;
    private Integer version;
    private String publisher;
}

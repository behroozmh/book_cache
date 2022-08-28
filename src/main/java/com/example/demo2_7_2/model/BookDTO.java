package com.example.demo2_7_2.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BookDTO {
    private String name;
    private String enName;
    private String isbn;
    private UUID uuid;
    private Date printDate;
    private Integer version;
    private String publisher;
}

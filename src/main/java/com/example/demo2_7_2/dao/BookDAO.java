package com.example.demo2_7_2.dao;

import com.example.demo2_7_2.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends CrudRepository<Book, Integer> {
}

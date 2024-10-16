package com.example.demolibrary.service;

import com.example.demolibrary.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    Page<Book> findAll(int page, int size);

    Book findById(int id);

    List<Book> findBooksByQuery(String query);

    Book save(Book book);

    void delete(Book book);

    void update(Book book);
}

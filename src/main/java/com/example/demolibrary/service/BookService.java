package com.example.demolibrary.service;

import com.example.demolibrary.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);
}

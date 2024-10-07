package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Book;

import java.util.List;

public interface BookRepository {
     List<Book> findAll();
     Book findById(int id);
}

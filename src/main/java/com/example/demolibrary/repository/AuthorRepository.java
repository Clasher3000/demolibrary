package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> findAll();

    Author findById(int id);
}

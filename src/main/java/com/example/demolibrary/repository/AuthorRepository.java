package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;

import java.util.List;

public interface AuthorRepository {
    public List<Author> findAll();
}

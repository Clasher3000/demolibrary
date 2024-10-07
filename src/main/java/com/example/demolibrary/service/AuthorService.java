package com.example.demolibrary.service;

import com.example.demolibrary.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(int id);

}

package com.example.demolibrary.service;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.repository.AuthorRepositoryImpl;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepositoryImpl authorRepository;

    public AuthorServiceImpl(AuthorRepositoryImpl authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
    return authorRepository.findAll();
    }
}

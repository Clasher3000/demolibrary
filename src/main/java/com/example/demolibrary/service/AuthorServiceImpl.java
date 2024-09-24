package com.example.demolibrary.service;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.repository.AuthorRepository;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
    return authorRepository.findAll();
    }
}

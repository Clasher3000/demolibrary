package com.example.demolibrary.service;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.repository.AuthorRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepositoryImpl authorRepository;

    public AuthorServiceImpl(AuthorRepositoryImpl authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
    return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id);
    }
}

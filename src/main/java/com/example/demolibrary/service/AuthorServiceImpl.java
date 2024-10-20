package com.example.demolibrary.service;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.entity.Book;
import com.example.demolibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
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

    @Override
    public Author save(Author author) {;
        return authorRepository.save(author);
    }

    public void update(Author author) {

        if (authorRepository.existsById(author.getId())) {
            authorRepository.save(author); // Зберігаємо оновленого автора
        } else {
            throw new RuntimeException("Author not found for id: " + author.getId());
        }
    }
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}

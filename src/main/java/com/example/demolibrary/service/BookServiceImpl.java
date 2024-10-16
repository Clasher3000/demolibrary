package com.example.demolibrary.service;

import com.example.demolibrary.entity.Book;
import com.example.demolibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findBooksByQuery(String query) {
        List<Book> booksByTitle = bookRepository.findByTitleContainingIgnoreCase(query);
        List<Book> booksByAuthor = bookRepository.findBooksByAuthorLastNameContainingIgnoreCase(query);
        List<Book> booksByKeyword = bookRepository.findBooksByKeyword(query);

        // Combine all results and remove duplicates
        Set<Book> resultSet = new HashSet<>();
        resultSet.addAll(booksByTitle);
        resultSet.addAll(booksByAuthor);
        resultSet.addAll(booksByKeyword);

        return new ArrayList<>(resultSet); // Convert back to List
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void update(Book book) {

        if (bookRepository.existsById(book.getId())) {
           bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found for id: " + book.getId());
        }
    }
}

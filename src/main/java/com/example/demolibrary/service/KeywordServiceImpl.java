package com.example.demolibrary.service;

import com.example.demolibrary.entity.Book;
import com.example.demolibrary.entity.Keyword;
import com.example.demolibrary.repository.KeywordRepository;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService{
    private KeywordRepository keywordRepository;
    private BookService bookService;


    public KeywordServiceImpl(KeywordRepository keywordRepository,BookService bookService) {
        this.keywordRepository = keywordRepository;
        this.bookService = bookService;
    }

    @Override
    public Keyword save(String word, int bookId) {
        Book tempBook = bookService.findById(bookId);
        Keyword keyword = new Keyword();
        keyword.setWord(word);
        keyword.setBook(tempBook);
        return keywordRepository.save(keyword);
    }

    @Override
    public void deleteById(int id) {
        keywordRepository.deleteById(id);
    }
}

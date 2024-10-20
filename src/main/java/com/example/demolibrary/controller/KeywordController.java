package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Book;
import com.example.demolibrary.entity.Keyword;
import com.example.demolibrary.repository.KeywordRepository;
import com.example.demolibrary.service.BookService;
import com.example.demolibrary.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/keywords")
public class KeywordController {

    private KeywordService keywordService;


    @Autowired
    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @PostMapping()
    public String addKeyword(@RequestParam int bookId, @RequestParam String keyword) {
        keywordService.save(keyword,bookId);
        return "redirect:/books/" + bookId; // Повертаємось на сторінку книги після додавання
    }
    @DeleteMapping("/{keywordId}")
    public String deleteKeyword(@PathVariable int keywordId, @RequestParam Long bookId) {
        keywordService.deleteById(keywordId);

        return "redirect:/books/" + bookId; // Повертаємось на сторінку книги після видалення
    }
}


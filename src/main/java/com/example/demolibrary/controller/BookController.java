package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Book;
import com.example.demolibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
public class BookController {
    private BookService bookService;


    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "book";
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}

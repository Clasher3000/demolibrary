package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String findAuthors(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors",authors);
        return "authors";
    }
    @GetMapping("/authors/{id}")
    public String findAuthors(@PathVariable int id, Model model){
        Author author = authorService.findById(id);
        model.addAttribute("author",author);
        return "author";
    }
}

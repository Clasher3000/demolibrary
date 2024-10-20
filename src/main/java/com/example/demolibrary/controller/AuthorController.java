package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors") // Базовий шлях для всіх методів
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String findAuthors(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("emptyAuthor", new Author());
        return "author/authors";
    }

    @GetMapping("/{id}")
    public String findAuthor(@PathVariable int id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/author";
    }


    @PostMapping
    public String createAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable int id, @ModelAttribute Author author) {
        author.setId(id);
        authorService.update(author);
        return "redirect:/authors/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }
}

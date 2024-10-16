package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.entity.Book;
import com.example.demolibrary.service.AuthorService;
import com.example.demolibrary.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private AuthorService authorService;
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;

    }

    @GetMapping()
    public String getBooks(Model model, @RequestParam(defaultValue = "0") int page) {
        int size = 6;
        Page<Book> books = bookService.findAll(page, size);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        model.addAttribute("totalItems", books.getTotalElements());
        model.addAttribute("emptyBook",new Book());
        return "book/books"; // Ensure this path is correct
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id, Model model) {
        List<Author> authors = authorService.findAll();
        Book book = bookService.findById(id);
        if (book == null) {
            model.addAttribute("errorMessage", "Book not found");
            return "basic/error"; // Ensure you have an error template
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "book/book"; // Ensure this path is correct
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        List<Book> books = bookService.findBooksByQuery(query);
        model.addAttribute("books", books);
        model.addAttribute("keyword", query);
        return "book/search-books"; // Ensure this path is correct
    }

    @PostMapping()
    public String saveBook(@ModelAttribute("emptyBook") Book book) {
        bookService.save(book);
        return "redirect:/books"; // Correct redirect path
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.update(book);
        return "redirect:/books"; // Correct redirect path
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id, Model model) {
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            model.addAttribute("errorMessage", "Book not found");
            return "basic/error"; // Ensure you have an error template
        }
        bookService.delete(existingBook);
        return "redirect:/books"; // Correct redirect path
    }
}


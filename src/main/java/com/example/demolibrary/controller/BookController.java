package com.example.demolibrary.controller;

import com.example.demolibrary.entity.Book;
import com.example.demolibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String getBooks(Model model, @RequestParam(defaultValue = "0") int page) {
        int size = 6;
        Page<Book> books = bookService.findAll(page,size);
        model.addAttribute("books",books);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        model.addAttribute("totalItems", books.getTotalElements());
        return "books";
    }
    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        if (book == null) {
            model.addAttribute("errorMessage", "Book not found");
            return "error"; // Повертаєш на сторінку помилки
        }
        model.addAttribute("book",book);
        return "book";
    }
    @GetMapping("/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        List<Book> books = bookService.findBooksByQuery(query);
        model.addAttribute("books", books);
        model.addAttribute("keyword", query); // Для відображення запиту в заголовку, якщо потрібно
        return "search-books"; // Повертає ту ж саму сторінку, що і для списку книг
    }
    @PostMapping()
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/books/";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute("book") Book updatedBook, Model model) {
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            model.addAttribute("errorMessage", "Book not found");
            return "error"; // Повертаєш на сторінку помилки
        }

        // Оновлюємо інформацію про книгу
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setCover(updatedBook.getCover());
        existingBook.setYear(updatedBook.getYear());
        existingBook.setKeywords(updatedBook.getKeywords());

        // Зберігаємо оновлену книгу
        bookService.save(existingBook);

        // Додаємо оновлену книгу до моделі
        model.addAttribute("book", existingBook);
        return "book"; // Повертає на сторінку з деталями книги
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id,Model model){
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            model.addAttribute("errorMessage", "Book not found");
            return "error"; // Повертаєш на сторінку помилки
        }
        bookService.delete(existingBook );
        return "redirect:/books/";
    }

}

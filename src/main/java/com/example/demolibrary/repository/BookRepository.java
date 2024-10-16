package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
     Page<Book> findAll(Pageable pageable);
     Book findById(int id);

     @Query("SELECT b FROM Book b JOIN b.keywords k WHERE k.word LIKE CONCAT('%', :keyword, '%')")
     List<Book> findBooksByKeyword(String keyword);

     List<Book> findByTitleContainingIgnoreCase(String title);

     List<Book> findBooksByAuthorLastNameContainingIgnoreCase(String authorName);
}

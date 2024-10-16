package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAll();

    Author findById(int id);
}

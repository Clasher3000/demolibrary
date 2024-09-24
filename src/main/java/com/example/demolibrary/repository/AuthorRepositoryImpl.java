package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    public List<Author> findAll(){
        //will be done later
        return null;
    }
}

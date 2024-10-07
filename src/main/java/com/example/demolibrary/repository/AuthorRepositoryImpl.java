package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    private List<Author> authors;

    public AuthorRepositoryImpl() {
         List<Book> books = new ArrayList<Book>();
         books.add(   new Book(1,"1984",null,
                 1949,"Some kinda description",
                 "https://i.imgur.com/PO4oR4q.png"));

        this.authors = new ArrayList<Author>();
        authors.add(new Author(1,"George","Orwell","UK",
                books,"https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/George_Orwell_press_photo.jpg/800px-George_Orwell_press_photo.jpg",
                LocalDate.of(1903, Month.JUNE,25),
                LocalDate.of(1950, Month.JANUARY,21) ));
        authors.add( new Author(2,"Agatha","Christie","UK",null,null,
                LocalDate.of(1890, Month.SEPTEMBER,15),
                LocalDate.of(1976, Month.JANUARY,12)));
    }

    @Override
    public List<Author> findAll(){
        return authors;
    }

    @Override
    public Author findById(int id) {
        return authors.get(id-1);
    }
}

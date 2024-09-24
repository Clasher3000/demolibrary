package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookRepository {
    public List findAll(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"1984",null, 1949,"https://i.imgur.com/PO4oR4q.png"));
        books.add(new Book(2,"Robinson Crusoe",null,1719,"https://i.imgur.com/KoPuIzH.png"));
        return books;

    }
}

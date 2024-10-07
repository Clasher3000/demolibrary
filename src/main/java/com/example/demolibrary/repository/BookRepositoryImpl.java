package com.example.demolibrary.repository;

import com.example.demolibrary.entity.Author;
import com.example.demolibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

    private List<Book> books;

    public BookRepositoryImpl() {
        this.books = new ArrayList<>();
        this.books.add(new Book(1,"1984",
                (new Author(1,"George","Orwell"
                        ,"UK",null, null,null, null)),
                1949,"Some kinda description",
                "https://i.imgur.com/PO4oR4q.png"));
        this.books.add(new Book(2,"Robinson Crusoe",null,
                1719,"Some kinda description",
                "https://i.imgur.com/KoPuIzH.png"));
    }

    public List findAll(){
        return books;
    }
    public Book findById(int id){
        return books.get(id-1);
    }
}

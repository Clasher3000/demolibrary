package com.example.demolibrary.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String word;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;
}

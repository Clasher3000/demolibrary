package com.example.demolibrary.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@Entity
@ToString(exclude = "keywords")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;
    private int year;
    private String description;
    private String cover;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Keyword> keywords;

}

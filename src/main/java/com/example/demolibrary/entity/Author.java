package com.example.demolibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String country;
    @OneToMany(mappedBy = "author",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Book> books;
    private String img;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "date_of_death")
    private LocalDate dateOfDeath;


}

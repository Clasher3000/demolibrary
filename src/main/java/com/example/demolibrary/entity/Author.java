package com.example.demolibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @NotNull
    @Length(min = 2)
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    @Length(min = 2)
    private String lastName;
    private String country;
    @OneToMany(mappedBy = "author",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)

    private List<Book> books;
    private String img;
    @Column(name = "date_of_birth")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Column(name = "date_of_death")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDeath;

    public boolean hasBooks() {
        return books != null && !books.isEmpty();
    }

}

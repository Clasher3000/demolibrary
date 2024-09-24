package com.example.demolibrary.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private int id;
    private String title;
    private Author author;
    private int year;
    private String cover;

    public Book() {
    }

    public Book(int id, String title, Author author, int year,String cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", year=" + year +
                ", cover='" + cover + '\'' +
                '}';
    }
}

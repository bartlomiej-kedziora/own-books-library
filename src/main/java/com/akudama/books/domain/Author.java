package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTHORS")
public class Author {
    private Long Id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
    private List<Book> books = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="author_id", unique = true)
    public Long getId() {
        return Id;
    }

    @Column(name = "year")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    public List<Book> getBooks() {
        return books;
    }

    private void setId(Long id) {
        Id = id;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}


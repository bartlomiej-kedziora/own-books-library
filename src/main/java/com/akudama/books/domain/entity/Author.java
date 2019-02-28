package com.akudama.books.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "AUTHORS")
public class Author {
    private Long id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
    private List<Book> books = new ArrayList<>();

    public Author(long id, int yearOfBirth, String name, String surname, String city, String country) {
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id", unique = true)
    public Long getId() {
        return id;
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
}


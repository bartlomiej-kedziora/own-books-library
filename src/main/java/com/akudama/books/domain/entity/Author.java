package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true)
    private Long id;

    @Column(name = "year")
    private int yearOfBirth;

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String city;
    @NotNull
    private String country;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public void removeBookById(long id) {
        List<Book> updatedBooks = getBooks()
                .stream()
                .filter(book -> !book.getId().equals(id))
                .collect(Collectors.toList());
        setBooks(updatedBooks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return yearOfBirth == author.yearOfBirth &&
                Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname) &&
                Objects.equals(city, author.city) &&
                Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfBirth, name, surname, city, country);
    }

}


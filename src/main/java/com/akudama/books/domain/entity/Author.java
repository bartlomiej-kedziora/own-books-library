package com.akudama.books.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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

    private String name;
    private String surname;
    private String city;
    private String country;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

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


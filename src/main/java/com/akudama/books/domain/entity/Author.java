package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        name = "AUTHORS",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"name", "surname", "year", "city"},
                name = "uk_author"
        )}
)
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
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}


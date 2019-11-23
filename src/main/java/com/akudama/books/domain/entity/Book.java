package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BOOKS", uniqueConstraints = {@UniqueConstraint(
        columnNames = {"year", "title", "titleEng", "series", "genre"},
        name = "uk_book"
)}
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private Long id;
    private int year;
    private String title;
    private String titleEng;
    private String series;
    private String genre;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "author_id")}
    )
    private List<Author> authors = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "worldscore_id")
    private WorldScore worldScore;
    @OneToMany(targetEntity = HomeCollectionItem.class, mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<HomeCollectionItem> homeCollectionItems = new ArrayList<>();

    public void removeAuthorById(long id) {
        List<Author> updatedAuthors = getAuthors()
                .stream()
                .filter(a -> !a.getId().equals(id))
                .collect(Collectors.toList());
        setAuthors(updatedAuthors);
    }
}

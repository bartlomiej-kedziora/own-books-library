package com.akudama.books.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "BOOKS", uniqueConstraints = {@UniqueConstraint(
        columnNames = {"year", "title", "titleEng", "series", "genre"},
        name = "uk_book"
    )}
)
public class Book {

    private Long id;
    private int year;
    private String title;
    private String titleEng;
    private String series;
    private String genre;
    private List<Author> authors = new ArrayList<>();
    private WorldScore worldScore;
    private List<HomeCollectionItem> homeCollectionItems = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public String getSeries() {
        return series;
    }

    public String getGenre() {
        return genre;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "author_id")}
    )
    public List<Author> getAuthors() {
        return authors;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "worldscore_id")
    public WorldScore getWorldScore() {
        return worldScore;
    }

    @OneToMany(targetEntity = HomeCollectionItem.class, mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<HomeCollectionItem> getHomeCollectionItems() {
        return homeCollectionItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(titleEng, book.titleEng) &&
                Objects.equals(series, book.series) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, titleEng, series, genre);
    }
}

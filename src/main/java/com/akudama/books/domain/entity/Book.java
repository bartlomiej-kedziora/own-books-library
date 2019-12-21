package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private Long id;

    @NotNull
    private int year;

    @NotNull
    private String title;
    private String titleEng;
    private String series;

    @NotNull
    private String genre;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")}
    )
    private List<Author> authors = new ArrayList<>();
    @Transient
    private WorldScore worldScore;
    @OneToMany(targetEntity = HomeCollectionItem.class, mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<HomeCollectionItem> homeCollectionItems = new ArrayList<>();

    public Book(Long id, int year, String title, String titleEng, String series, String genre,
            List<Author> authors, List<HomeCollectionItem> homeCollectionItems) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.titleEng = titleEng;
        this.series = series;
        this.genre = genre;
        this.authors = authors;
        this.homeCollectionItems = homeCollectionItems;
    }

    public void removeAuthorById(long id) {
        List<Author> updatedAuthors = getAuthors()
                .stream()
                .filter(a -> !a.getId().equals(id))
                .collect(Collectors.toList());
        setAuthors(updatedAuthors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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

package com.akudama.books.domain.entity;

import java.util.ArrayList;
import java.util.List;
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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {

    private Long id;
    private int year;
    private String titlePl;
    private String titleEn;
    private String series;
    private String genre;
    private List<Author> authors = new ArrayList<>();
    private WorldScore worldScore;
    private List<HomeCollectionItem> homeCollectionItems = new ArrayList<>();

    public Book(long id, int year, String titlePl, String titleEn, String series, String genre) {
        this.id = id;
        this.year = year;
        this.titlePl = titlePl;
        this.titleEn = titleEn;
        this.series = series;
        this.genre = genre;
    }

    public Book(Long id, int year, String titlePl, String titleEn, String series,
            String genre, List<Author> authors, WorldScore worldScore) {
        this.id = id;
        this.year = year;
        this.titlePl = titlePl;
        this.titleEn = titleEn;
        this.series = series;
        this.genre = genre;
        this.authors = authors;
        this.worldScore = worldScore;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", unique = true)
    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitlePl() {
        return titlePl;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getSeries() {
        return series;
    }

    public String getGenre() {
        return genre;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_author_book",
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
}

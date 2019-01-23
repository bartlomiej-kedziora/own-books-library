package com.akudama.books.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    private MyScore myScore;
    private WorldScore worldScore;
    private HomeCollection homeCollection;

    public Book() {
    }

    public Book(String titlePl, String titleEn, String series, String genre) {
        this.titlePl = titlePl;
        this.titleEn = titleEn;
        this.series = series;
        this.genre = genre;
    }

    @Id
    @GeneratedValue
    @NotNull
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
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")}
    )
    public List<Author> getAuthors() {
        return authors;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "myscore_id")
    public MyScore getMyScore() {
        return myScore;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "worldscore_id")
    public WorldScore getWorldScore() {
        return worldScore;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "homecollection_id")
    public HomeCollection getHomeCollection() {
        return homeCollection;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTitlePl(String titlePl) {
        this.titlePl = titlePl;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setMyScore(MyScore myScore) {
        this.myScore = myScore;
    }

    public void setWorldScore(WorldScore worldScore) {
        this.worldScore = worldScore;
    }

    public void setHomeCollection(HomeCollection homeCollection) {
        this.homeCollection = homeCollection;
    }
}

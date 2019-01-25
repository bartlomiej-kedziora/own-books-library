package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
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

//    public BookDto(Long id, int year, String titlePl, String titleEn, String series, String genre) {
//        this.id = id;
//        this.year = year;
//        this.titlePl = titlePl;
//        this.titleEn = titleEn;
//        this.series = series;
//        this.genre = genre;
//    }
}

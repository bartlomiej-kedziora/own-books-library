package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsDto {
    private Long id;
    private int year;
    private String titlePl;
    private String titleEn;
    private String series;
    private String genre;
    private List<AuthorDto> authors = new ArrayList<>();
    private ScoreDto myScore;
    private ScoreDto worldScore;
    private HomeCollectionDto homeCollection;

    @Getter
    @AllArgsConstructor
    public static class AuthorDto {
        private long id;
        private String name;
        private String surname;
    }
}

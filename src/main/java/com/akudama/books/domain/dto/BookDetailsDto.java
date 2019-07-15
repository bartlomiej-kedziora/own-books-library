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
    private ScoreDto worldScore;
    private List<HomeCollectionItemDto> homeCollectionItems = new ArrayList<>();
}

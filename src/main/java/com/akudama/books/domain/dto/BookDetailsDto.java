package com.akudama.books.domain.dto;

import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.MyScore;
import com.akudama.books.domain.entity.WorldScore;
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
    private List<Author> authors = new ArrayList<>();
    private MyScore myScore;
    private WorldScore worldScore;
    private HomeCollection homeCollection;
}

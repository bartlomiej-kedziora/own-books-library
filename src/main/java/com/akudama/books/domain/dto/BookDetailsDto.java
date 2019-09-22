package com.akudama.books.domain.dto;

import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.domain.entity.WorldScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDetailsDto extends BookDto {

    private List<AuthorDto> authors = new ArrayList<>();
    private WorldScore worldScore;

    public BookDetailsDto(Long id, int year, String title, String titleEng, String series, String genre, List<AuthorDto> authors, WorldScore worldScore) {
        super(id, year, title, titleEng, series, genre);
        this.authors = authors;
        this.worldScore = worldScore;
    }
}

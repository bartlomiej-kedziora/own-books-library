package com.akudama.books.domain.dto;

import com.akudama.books.domain.entity.WorldScore;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDetailsDto extends BookDto {

    private Set<AuthorDto> authors = new HashSet<>();
    private WorldScore worldScore;

    public BookDetailsDto(Long id, int year, String title, String titleEng, String series, String genre,
            Set<AuthorDto> authors, WorldScore worldScore) {
        super(id, year, title, titleEng, series, genre);
        this.authors = authors;
        this.worldScore = worldScore;
    }
}

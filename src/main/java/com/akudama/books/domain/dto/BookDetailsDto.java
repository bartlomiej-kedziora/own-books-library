package com.akudama.books.domain.dto;

import com.akudama.books.domain.entity.WorldScore;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDetailsDto extends BookDto {

    private List<AuthorDto> authors = new ArrayList<>();
    private WorldScore worldScore;

    public BookDetailsDto(Long id, int year, String title, String titleEng, String series, String genre,
            List<AuthorDto> authors, WorldScore worldScore) {
        super(id, year, title, titleEng, series, genre);
        this.authors = authors;
        this.worldScore = worldScore;
    }
}

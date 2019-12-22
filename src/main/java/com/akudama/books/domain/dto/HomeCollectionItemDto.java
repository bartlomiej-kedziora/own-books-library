package com.akudama.books.domain.dto;

import static com.akudama.books.domain.dto.ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder;

import com.akudama.books.domain.entity.MyScore;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionItemDto {

    private Long id;
    private BookDto book;
    private ScoreDto myScore = aScoreDtoBuilder().withValue(0).build();
    private Set<FormDto> forms = new HashSet<>();
    private Set<LangDto> langs = new HashSet<>();
}

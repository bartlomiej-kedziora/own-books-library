package com.akudama.books.domain.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionItemDto {

    private Long id;
    private BookDto book;
    private ScoreDto myScore;
    private List<FormDto> forms = new ArrayList<>();
    private List<LangDto> langs = new ArrayList<>();
}

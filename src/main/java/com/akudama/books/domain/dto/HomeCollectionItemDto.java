package com.akudama.books.domain.dto;

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
public class HomeCollectionItemDto {

    private Long id;
    private BookDto book;
    private ScoreDto myScore;
    private List<FormDto> forms = new ArrayList<>();
    private List<LangDto> langs = new ArrayList<>();
}

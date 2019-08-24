package com.akudama.books.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeCollectionItemDto {

    private Long id;
    private BookDto book;
    private ScoreDto myScore;
    private List<FormDto> forms;
    private List<LangDto> langs;
}

package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomeCollectionDto {
    private Long id;
    private List<FormDto> forms = new ArrayList<>();
    private List<LangDto> langs = new ArrayList<>();

}

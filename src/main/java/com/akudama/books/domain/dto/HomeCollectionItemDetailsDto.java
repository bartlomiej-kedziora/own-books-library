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
public class HomeCollectionItemDetailsDto extends HomeCollectionItemDto {

    private HomeCollectionDetailsDto homeCollection;

    public HomeCollectionItemDetailsDto(Long id, BookDto book, ScoreDto myScore, List<FormDto> forms, List<LangDto> langs, HomeCollectionDetailsDto homeCollection) {
        super(id, book, myScore, forms, langs);
        this.homeCollection = homeCollection;
    }
}

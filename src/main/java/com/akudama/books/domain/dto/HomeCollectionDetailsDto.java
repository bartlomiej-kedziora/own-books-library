package com.akudama.books.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionDetailsDto extends HomeCollectionItemDto {

    private List<HomeCollectionItemDetailsDto> homeCollectionItems;

    public HomeCollectionDetailsDto(Long id, BookDto book, ScoreDto myScore, List<FormDto> forms, List<LangDto> langs,
            List<HomeCollectionItemDetailsDto> homeCollectionItems) {
        super(id, book, myScore, forms, langs);
        this.homeCollectionItems = homeCollectionItems;
    }
}

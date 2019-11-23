package com.akudama.books.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionItemDetailsDto extends HomeCollectionItemDto {

    private HomeCollectionDetailsDto homeCollection;

    public HomeCollectionItemDetailsDto(Long id, BookDto book, ScoreDto myScore, List<FormDto> forms,
            List<LangDto> langs, HomeCollectionDetailsDto homeCollection) {
        super(id, book, myScore, forms, langs);
        this.homeCollection = homeCollection;
    }
}

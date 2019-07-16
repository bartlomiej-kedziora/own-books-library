package com.akudama.books.domain.dto;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionItemDetailsDto extends HomeCollectionItemDto {

    private HomeCollectionDto homeCollection;

    public HomeCollectionItemDetailsDto(Long id, BookDto book, ScoreDto myScore, Set<FormDto> forms,
            Set<LangDto> langs, HomeCollectionDto homeCollection) {
        super(id, book, myScore, forms, langs);
        this.homeCollection = homeCollection;
    }
}

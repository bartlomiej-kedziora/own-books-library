package com.akudama.books.domain.dto;

import java.util.List;

import com.akudama.books.auth.user.UserDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeCollectionDetailsDto extends HomeCollectionItemDto {

    private List<HomeCollectionItemDetailsDto> homeCollectionItems;

    public HomeCollectionDetailsDto(Long id, BookDto book, ScoreDto myScore, List<FormDto> forms, List<LangDto> langs, List<HomeCollectionItemDetailsDto> homeCollectionItems) {
        super(id, book, myScore, forms, langs);
        this.homeCollectionItems = homeCollectionItems;
    }
}

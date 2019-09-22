package com.akudama.books.domain.dto;

import com.akudama.books.auth.user.UserDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeCollectionDto {

    private Long id;
    private UserDetailsDto user;
    private List<HomeCollectionItemDto> homeCollectionItems;
}

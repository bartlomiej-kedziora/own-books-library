package com.akudama.books.domain.dto;

import java.util.List;

import com.akudama.books.auth.user.UserDetailsDto;
import com.akudama.books.auth.user.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HomeCollectionDto {

    private Long id;
    private UserDetailsDto user;
    private List<HomeCollectionItemDto> homeCollectionItems;
}

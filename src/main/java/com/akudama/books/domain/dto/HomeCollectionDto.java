package com.akudama.books.domain.dto;

import java.util.List;

import com.akudama.books.auth.user.UserDetailsDto;
import com.akudama.books.auth.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeCollectionDto {

    private Long id;
//    private UserDetailsDto user;
    private List<HomeCollectionItemDto> homeCollectionItems;
}

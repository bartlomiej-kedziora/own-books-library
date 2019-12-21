package com.akudama.books.domain.dto;

import com.akudama.books.auth.user.UserDetailsDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeCollectionDto {

    private Long id;
    private BasicUserDto user;
    private List<HomeCollectionItemDto> homeCollectionItems;
}

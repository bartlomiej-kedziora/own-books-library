package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {

    private Long id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
    private List<BookDto> books;
}

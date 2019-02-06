package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
}
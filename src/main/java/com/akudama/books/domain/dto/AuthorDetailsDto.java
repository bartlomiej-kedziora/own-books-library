package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDetailsDto extends AuthorDto {

    private List<BookDto> books;

    public AuthorDetailsDto(Long id, int yearOfBirth, String name, String surname, String city, String country, List<BookDto> books) {
        super(id, yearOfBirth, name, surname, city, country);
        this.books = books;
    }
}

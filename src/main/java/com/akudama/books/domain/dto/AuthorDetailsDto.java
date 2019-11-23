package com.akudama.books.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDetailsDto extends AuthorDto {

    private List<BookDto> books;

    public AuthorDetailsDto(Long id, int yearOfBirth, String name, String surname, String city, String country,
            List<BookDto> books) {
        super(id, yearOfBirth, name, surname, city, country);
        this.books = books;
    }
}

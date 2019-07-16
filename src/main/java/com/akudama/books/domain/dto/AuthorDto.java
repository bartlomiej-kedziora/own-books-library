package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDto {

    protected Long id;
    protected int yearOfBirth;
    protected String name;
    protected String surname;
    protected String city;
    protected String country;
}

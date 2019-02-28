package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailsDto {
    private Long id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
    private List<BookDto> books = new ArrayList<>();

    @Getter
    @AllArgsConstructor
    public static class BookDto {
        private long id;
        private String titlePl;
        private String titleEn;
    }
}
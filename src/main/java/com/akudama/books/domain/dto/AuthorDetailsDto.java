package com.akudama.books.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AuthorDetailsDto {
    private final Long id;
    private final int yearOfBirth;
    private final String name;
    private final String surname;
    private final String city;
    private final String country;
    private final List<BookDto> books;

    private AuthorDetailsDto(Long id, int yearOfBirth, String name, String surname, String city, String country, List<BookDto> books) {
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
        this.books = books;
    }

    public static final class AuthorDetailsDtoBuilder {
        private Long id;
        private int yearOfBirth;
        private String name;
        private String surname;
        private String city;
        private String country;
        private List<BookDto> books;

        private AuthorDetailsDtoBuilder() {
        }

        public static AuthorDetailsDtoBuilder aAuthorDetailsDtoBuilder() {
            return new AuthorDetailsDtoBuilder();
        }

        public AuthorDetailsDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AuthorDetailsDtoBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public AuthorDetailsDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AuthorDetailsDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public AuthorDetailsDtoBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AuthorDetailsDtoBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public AuthorDetailsDtoBuilder withBooks(List<BookDto> books) {
            this.books = books;
            return this;
        }

        public AuthorDetailsDto build() {
            return new AuthorDetailsDto(id, yearOfBirth, name, surname, city, country, books);
        }
    }
}

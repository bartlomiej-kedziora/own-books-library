package com.akudama.books.domain.dto;

import lombok.Getter;

@Getter
public class AuthorDto {
    private final Long id;
    private final int yearOfBirth;
    private final String name;
    private final String surname;
    private final String city;
    private final String country;

    private AuthorDto(Long id, int yearOfBirth, String name, String surname, String city, String country) {
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
    }

    public static final class AuthorDtoBuilder {
        private Long id;
        private int yearOfBirth;
        private String name;
        private String surname;
        private String city;
        private String country;

        private AuthorDtoBuilder() {
        }

        public AuthorDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public AuthorDtoBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public AuthorDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AuthorDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public AuthorDtoBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AuthorDtoBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public AuthorDto build() {
            return new AuthorDto(id, yearOfBirth, name, surname, city, country);
        }
    }
}
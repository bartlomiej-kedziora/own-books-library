package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthorDto {
    private Long Id;
    private int yearOfBirth;
    private String name;
    private String surname;
    private String city;
    private String country;
}